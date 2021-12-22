package fun.qianfg.cimserver.handler;

import fun.qianfg.cst.MessageTypeCst;
import fun.qianfg.dto.MessageDto;
import fun.qianfg.dto.Session;
import fun.qianfg.util.ChannelMap;
import fun.qianfg.util.SessionMap;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * Function: 服务端处理器，用来收发消息
 *
 * @author qianfg
 * @date 2021/12/12 下午8:50
 * @Email: 287541326@qq.com
 */
@Slf4j
@ChannelHandler.Sharable
public class ServerHandler extends SimpleChannelInboundHandler<MessageDto> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageDto messageDto) {
        log.info("收到用户【{}】发来的消息：{}", messageDto.getName(), messageDto.getMsg());

        if (MessageTypeCst.LOGIN == messageDto.getType()) {
            // 登录消息,保存客户端与channel之间的关系
            ChannelMap.put(messageDto.getUserId(), (NioSocketChannel) ctx.channel());
            SessionMap.put(messageDto.getUserId(), new Session(messageDto.getUserId(), messageDto.getName()));
            log.info("用户【{}】上线...", messageDto.getName());
        }

        MessageDto msg = MessageDto.builder()
                .name("server-qianfg")
                .msg("hello,client!")
                .type(MessageTypeCst.MSG)
                .userId(1L)
                .build();
        ctx.writeAndFlush(msg);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        Long userId = ChannelMap.getUserId((NioSocketChannel) ctx.channel());
        Session session = SessionMap.get(userId);
        log.info("用户【{}】下线...", session.getName());
        ChannelMap.remove(userId);
        SessionMap.remove(userId);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        log.info("ServerHandler发送异常，异常信息：{}", cause.getMessage());
    }
}

package fun.qianfg.cimclient.handler;

import fun.qianfg.cst.MessageTypeCst;
import fun.qianfg.dto.MessageDto;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * Function: 客户端处理器，用于收发消息
 *
 * @author qianfg
 * @date 2021/12/12 下午11:09
 * @Email: 287541326@qq.com
 */
@Slf4j
@ChannelHandler.Sharable
public class ClientHandler extends SimpleChannelInboundHandler<MessageDto> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageDto messageDto) {
        log.info("收到用户【{}】消息：{}", messageDto.getName(), messageDto.getMsg());
        ctx.channel().eventLoop().schedule(() -> {
            MessageDto msg = MessageDto.builder()
                    .msg("hello,server!")
                    .name("client-qianfg")
                    .type(MessageTypeCst.MSG)
                    .userId(2L)
                    .build();
            ctx.writeAndFlush(msg);
        }, 2, TimeUnit.SECONDS);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        log.info("Connect successfully...");
        MessageDto msg = MessageDto.builder()
                .msg("hello,server!")
                .name("client-qianfg")
                .type(MessageTypeCst.LOGIN)
                .userId(2L)
                .build();
        ctx.writeAndFlush(msg);
        //每个2s发送一次
//        ctx.channel().eventLoop().scheduleAtFixedRate(() -> ctx.writeAndFlush(msg), 0, 2, TimeUnit.SECONDS);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if (event.state() == IdleState.WRITER_IDLE) {
                ctx.channel().writeAndFlush(Unpooled.copiedBuffer("ping", CharsetUtil.UTF_8));
            }
        }
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        log.info("ClientHandler发送异常：{}", cause.getMessage());
    }
}

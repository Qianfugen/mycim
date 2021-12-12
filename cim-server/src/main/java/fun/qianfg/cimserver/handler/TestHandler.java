package fun.qianfg.cimserver.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Function: 测试处理器
 *
 * @author qianfg
 * @date 2021/12/12 下午10:04
 * @Email: 287541326@qq.com
 */
@Slf4j
@ChannelHandler.Sharable
public class TestHandler extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        log.info("TestHandler接收到消息：{}", byteBuf.toString(CharsetUtil.UTF_8));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.channel().writeAndFlush(Unpooled.copiedBuffer("hello, just a test!", CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("TestHandler发送异常：{}", cause.getMessage());
    }
}

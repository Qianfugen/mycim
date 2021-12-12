package cn.qianfg.cimserver.init;

import cn.qianfg.cimserver.handler.ServerHandler;
import cn.qianfg.cimserver.handler.TestHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * Function: 初始化通道处理器
 *
 * @author qianfg
 * @date 2021/12/12 下午8:54
 * @Email: 287541326@qq.com
 */
public class ServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) {
        channel.pipeline().addLast(new TestHandler());
        channel.pipeline().addLast(new ServerHandler());
    }
}

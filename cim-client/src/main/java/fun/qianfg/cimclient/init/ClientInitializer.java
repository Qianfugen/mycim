package fun.qianfg.cimclient.init;

import fun.qianfg.cimclient.handler.ClientHandler;
import fun.qianfg.decoder.MessageDecoder;
import fun.qianfg.encoder.MessageEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * Function: 初始化通道处理器
 *
 * @author qianfg
 * @date 2021/12/12 下午11:22
 * @Email: 287541326@qq.com
 */
public class ClientInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) {
        channel.pipeline().addLast(new MessageEncoder())
                .addLast(new MessageDecoder())
                .addLast(new ClientHandler());
    }
}

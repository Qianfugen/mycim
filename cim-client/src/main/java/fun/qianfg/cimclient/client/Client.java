package fun.qianfg.cimclient.client;

import fun.qianfg.cimclient.init.ClientInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

/**
 * Function: 客户端
 *
 * @author qianfg
 * @date 2021/12/12 下午11:02
 * @Email: 287541326@qq.com
 */
@Slf4j
@Component
public class Client {

    /**
     * 服务端地址
     */
    @Value("${cim.server.ip}")
    private String ip;

    /**
     * 服务端端口
     */
    @Value("${cim.server.port}")
    private int port;

    private EventLoopGroup group = new NioEventLoopGroup();

    /**
     * 启动
     */
    public void start() {
        Bootstrap bootstrap = new Bootstrap()
                .group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .handler(new ClientInitializer());

        ChannelFuture channelFuture = bootstrap.connect(new InetSocketAddress(ip, port)).syncUninterruptibly();
//        channelFuture.channel().closeFuture().syncUninterruptibly();
        if (channelFuture.isSuccess()) {
            log.info("CIM Client start...");
        }
    }

    /**
     * 销毁
     */
    public void destory() {
        group.shutdownGracefully().syncUninterruptibly();
    }

}

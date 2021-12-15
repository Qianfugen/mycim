package fun.qianfg.cimserver.server;

import fun.qianfg.cimserver.init.ServerInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Function: 服务端
 *
 * @author qianfg
 * @date 2021/12/12 下午8:26
 * @Email: 287541326@qq.com
 */
@Slf4j
@Component
public class Server {

    /**
     * 负责处理连接
     */
    private final EventLoopGroup bossGroup = new NioEventLoopGroup(1);

    /**
     * 负责处理业务
     */
    private final EventLoopGroup workGroup = new NioEventLoopGroup();

    /**
     * netty服务监听端口
     */
    private int nettyPort = 11211;

    /**
     * 启动
     */
    public void start() throws InterruptedException {
        ServerBootstrap serverBootstrap = new ServerBootstrap()
                .group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childHandler(new ServerInitializer());

        ChannelFuture channelFuture = serverBootstrap.bind(nettyPort).sync();
//        channelFuture.channel().closeFuture().syncUninterruptibly();
        if (channelFuture.isSuccess()) {
            log.info("CIM Server start...");
        }
    }

    /**
     * 销毁
     */
    public void destory() {
        bossGroup.shutdownGracefully().syncUninterruptibly();
        workGroup.shutdownGracefully().syncUninterruptibly();
        log.info("CIM Server stop...");
    }

}

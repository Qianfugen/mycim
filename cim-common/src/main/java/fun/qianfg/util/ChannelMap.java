package fun.qianfg.util;

import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Function: 保存用户和通道的映射关系
 *
 * @author qianfg
 * @date 2021/12/12 下午5:59
 * @Email: 287541326@qq.com
 */
public class ChannelMap {

    /**
     * id和Channel的映射关系
     */
    private static final Map<Long, NioSocketChannel> CHANNEL_MAP = new ConcurrentHashMap<>(16);

    /**
     * 添加channel
     */
    public static void put(Long id, NioSocketChannel channel) {
        CHANNEL_MAP.put(id, channel);
    }

    /**
     * 获取channel
     */
    public NioSocketChannel get(Long id) {
        return CHANNEL_MAP.get(id);
    }

    /**
     * 删除channel
     */
    public static void remove(Long id) {
        CHANNEL_MAP.remove(id);
    }

    /**
     * 获取注册用户信息
     */
    public static Long getUserId(SocketChannel channel) {
        return CHANNEL_MAP.entrySet().stream().filter(s -> s.getValue().equals(channel)).map(Map.Entry::getKey).findFirst().get();
    }

}

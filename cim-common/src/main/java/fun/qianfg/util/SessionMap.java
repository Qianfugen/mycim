package fun.qianfg.util;

import fun.qianfg.dto.Session;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Function: 保存用户和回话的映射关系
 *
 * @author qianfg
 * @date 2021/12/12 下午5:59
 * @Email: 287541326@qq.com
 */
public class SessionMap {

    /**
     * id和Session的映射关系
     */
    private static final Map<Long, Session> SESSION_MAP = new ConcurrentHashMap<>(16);

    /**
     * 添加Session
     */
    public static void put(Long id, Session session) {
        SESSION_MAP.put(id, session);
    }

    /**
     * 获取Session
     */
    public static Session get(Long id) {
        return SESSION_MAP.get(id);
    }

    /**
     * 删除Session
     */
    public static void remove(Long id) {
        SESSION_MAP.remove(id);
    }

}

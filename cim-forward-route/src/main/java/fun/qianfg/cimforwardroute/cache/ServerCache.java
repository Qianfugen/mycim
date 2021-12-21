package fun.qianfg.cimforwardroute.cache;

import fun.qianfg.cimforwardroute.kit.ZkUtil;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Function: 服务器节点缓存
 *
 * @author qianfg
 * @date 2021/12/20 下午10:53
 * @Email: 287541326@qq.com
 */
@Component
public class ServerCache {

    private Map<String, String> cache = new ConcurrentHashMap<>();

//    private final ZkUtil zkUtil;

    private AtomicLong index = new AtomicLong();

//    public ServerCache(@Lazy ZkUtil zkUtil) {
//        this.zkUtil = zkUtil;
//    }

    /**
     * 新增缓存
     */
    public void addCache(String key) {
        cache.put(key, key);
    }

    /**
     * 更新缓存
     */
    public void updateCache(List<String> nodes) {
        cache.clear();
        for (String node : nodes) {
            String key = node.split("-")[1];
            addCache(node);
        }
    }

    /**
     * 获取所有的服务列表
     *
     * @return
     */
    public List<String> getAll() {
        List<String> list = new ArrayList<>();

        if (cache.isEmpty()) {
//            List<String> allNodes = zkUtil.getAllNodes();
//            for (String node : allNodes) {
//                String key = node.split("-")[1];
//                addCache(node);
//            }
        }
        list.addAll(cache.keySet());

        return list;
    }

    /**
     * 选取服务器
     */
    public String selectServer() {
        List<String> all = getAll();
        if (all.isEmpty()) {
            throw new RuntimeException("CIM 服务器可用服务列表为空");
        }
        long position = index.incrementAndGet() % all.size();
        if (position < 0) {
            position = 0;
        }

        return all.get((int) position);
    }

}

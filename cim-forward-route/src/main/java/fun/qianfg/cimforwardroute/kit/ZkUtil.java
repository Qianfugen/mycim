package fun.qianfg.cimforwardroute.kit;

import fun.qianfg.cimforwardroute.cache.ServerCache;
import lombok.extern.slf4j.Slf4j;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Function: Zookeeper工具类
 *
 * @author qianfg
 * @date 2021/12/16 下午10:52
 * @Email: 287541326@qq.com
 */
@Slf4j
@Component
public class ZkUtil {

    @Value("${app.zk.zkRoot}")
    private String zkRoot;

    private final ZkClient zkClient;

    private final ServerCache serverCache;

    public ZkUtil(ZkClient zkClient, ServerCache serverCache) {
        this.zkClient = zkClient;
        this.serverCache = serverCache;
    }

    public void subscribeEvent(String path) {
        zkClient.subscribeChildChanges(path, (parentPath, currentChilds) -> {
            log.info("清除/更新本地缓存 parentPath=【{}】,currentChilds=【{}】", parentPath, currentChilds);
            //更新所有缓存/先删除 再新增
            serverCache.updateCache(currentChilds);
        });
    }

    /**
     * 获取所有注册节点
     */
    public List<String> getAllNodes() {
        List<String> children = zkClient.getChildren(zkRoot);
        log.info("查询所有节点成功，nodes=【{}】", children);
        return children;
    }

}

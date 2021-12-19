package fun.qianfg.cimforwardroute.kit;

import lombok.extern.slf4j.Slf4j;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.stereotype.Component;

/**
 * Function: Zookeeper工具类
 *
 * @author qianfg
 * @date 2021/12/16 下午10:52
 * @Email: 287541326@qq.com
 */
@Slf4j
@Component
public class ZKit {

    private final ZkClient zkClient;

    public ZKit(ZkClient zkClient) {
        this.zkClient = zkClient;
    }
}

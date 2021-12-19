package fun.qianfg.cimforwardroute.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Function: zookeeper配置信息
 *
 * @author qianfg
 * @date 2021/12/16 下午10:57
 * @Email: 287541326@qq.com
 */
@Data
@Component
public class AppConfiguration {

    @Value("${app.zk.zkRoot}")
    private String zkRoot;

    @Value("${app.zk.zkAddr}")
    private String zkAddr;

    @Value("${server.port}")
    private int port;

}

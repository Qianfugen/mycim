package fun.qianfg.cimforwardroute.kit;

import fun.qianfg.cimforwardroute.config.AppConfiguration;
import fun.qianfg.util.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Function: 监听器
 *
 * @author qianfg
 * @date 2021/12/20 下午10:41
 * @Email: 287541326@qq.com
 */
@Slf4j
@Component
public class ServerListListener implements Runnable {

    private ZkUtil zkUtil;

    private AppConfiguration appConfiguration;

    public ServerListListener() {
        this.zkUtil = SpringUtils.getBean(ZkUtil.class);
        this.appConfiguration = SpringUtils.getBean(AppConfiguration.class);
    }

    @Override
    public void run() {
        //注册监听服务
        zkUtil.subscribeEvent(appConfiguration.getZkRoot());
    }
}

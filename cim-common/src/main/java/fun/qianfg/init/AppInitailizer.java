package fun.qianfg.init;

import fun.qianfg.util.SpringUtils;
import org.junit.jupiter.api.Order;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * Function: 实现ApplicationRunner接口，springBoot项目启动时，会运行其run方法
 *
 * @author qianfg
 * @date 2021/12/20 下午11:54
 * @Email: 287541326@qq.com
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AppInitailizer implements ApplicationRunner {

    private final ApplicationContext context;

    public AppInitailizer(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        SpringUtils.initApplicationContext(context);
    }
}

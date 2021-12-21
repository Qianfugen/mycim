package fun.qianfg.cimforwardroute;

import fun.qianfg.cimforwardroute.kit.ServerListListener;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Function: 启动类
 *
 * @author qianfg
 * @date 2021/12/16 下午10:51
 * @Email: 287541326@qq.com
 */
@SpringBootApplication
public class CimForwardRouteApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CimForwardRouteApplication.class, args);
    }

    @Override
    public void run(String... args) {
        //监听服务
        Thread thread = new Thread(new ServerListListener());
        thread.setName("zk-listener");
        thread.start();
    }
}

package fun.qianfg.cimserver;

import fun.qianfg.cimserver.server.Server;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Function: 程序启动入口
 *
 * @author qianfg
 * @date 2021/12/12 下午5:59
 * @Email: 287541326@qq.com
 */
@SpringBootApplication
public class CimServerApplication implements CommandLineRunner {

    private final Server server;

    public CimServerApplication(Server server) {
        this.server = server;
    }

    public static void main(String[] args) {
        SpringApplication.run(CimServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        server.start();
    }
}

package fun.qianfg.cimclient;

import fun.qianfg.cimclient.client.Client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Function: 启动客户端
 *
 * @author qianfg
 * @date 2021/12/12 下午8:54
 * @Email: 287541326@qq.com
 */
@SpringBootApplication
public class CimClientApplication implements CommandLineRunner {

    private final Client client;

    public CimClientApplication(Client client) {
        this.client = client;
    }

    public static void main(String[] args) {
        SpringApplication.run(CimClientApplication.class, args);
    }

    @Override
    public void run(String... args) {
        client.start();
    }
}

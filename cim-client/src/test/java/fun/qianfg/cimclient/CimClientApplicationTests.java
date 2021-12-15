package fun.qianfg.cimclient;

import fun.qianfg.cst.MessageTypeCst;
import fun.qianfg.dto.MessageDto;
import fun.qianfg.util.Hessian2Utils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CimClientApplicationTests {

    @Test
    void contextLoads() {
        MessageDto msg = new MessageDto();
        msg.setMsg("hello,server!");
        msg.setName("client-qianfg");
        msg.setType(MessageTypeCst.MSG);
        msg.setUserId(1L);
        byte[] data = Hessian2Utils.serialize(msg);
        System.out.println(data);
    }

}

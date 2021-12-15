package fun.qianfg.util;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Function: 序列化工具
 *
 * @author qianfg
 * @date 2021/12/15 下午10:31
 * @Email: 287541326@qq.com
 */
@Slf4j
public class Hessian2Utils {

    /**
     * JavaBean序列化
     */
    public static <T> byte[] serialize(T obj) {
        ByteArrayOutputStream os;
        Hessian2Output ho;
        try {
            os = new ByteArrayOutputStream();
            ho = new Hessian2Output(os);
            ho.writeObject(obj);
            ho.flush();
            ho.close();
            os.close();
            return os.toByteArray();
        } catch (IOException e) {
            log.info("Hessian2Utils序列化异常：{}", e.getMessage());
            return null;
        }
    }

    /**
     * JavaBean反序列化
     */
    public static <T> T deserialize(byte[] data, Class<T> clazz) {
        T bean;
        Hessian2Input hi;
        ByteArrayInputStream is;
        try {
            is = new ByteArrayInputStream(data);
            hi = new Hessian2Input(is);
            bean = (T) hi.readObject(clazz);
            return bean;
        } catch (Exception e) {
            log.info("Hessian2Utils反序列化异常：{}", e.getMessage());
            return null;
        }
    }

}

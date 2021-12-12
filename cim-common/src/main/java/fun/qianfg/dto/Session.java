package fun.qianfg.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Function: 会话信息
 *
 * @author qianfg
 * @date 2021/12/12 下午9:15
 * @Email: 287541326@qq.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Session {
    private Long userId;
    private String name;
}

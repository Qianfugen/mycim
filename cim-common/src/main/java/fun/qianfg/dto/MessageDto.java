package fun.qianfg.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Function: 发送消息DTO
 *
 * @author qianfg
 * @date 2021/12/12 下午5:59
 * @Email: 287541326@qq.com
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("发送消息DTO")
public class MessageDto implements Serializable {

    @ApiModelProperty("消息类型")
    private int type;

    @ApiModelProperty("发送的消息内容")
    private String msg;

    @ApiModelProperty("用户Id")
    private Long userId;

    @ApiModelProperty("用户名")
    private String name;

}

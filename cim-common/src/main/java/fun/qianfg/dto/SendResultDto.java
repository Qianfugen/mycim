package fun.qianfg.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Function: 发送结果DTO
 *
 * @author qianfg
 * @date 2021/12/12 下午5:59
 * @Email: 287541326@qq.com
 */
@Data
@ApiModel("发送结果DTO")
public class SendResultDto {

    @ApiModelProperty("发送结果")
    private String msg;

}

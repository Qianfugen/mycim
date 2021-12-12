package fun.qianfg.dto;

import fun.qianfg.cst.ResultCodeCst;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Function: 返回数据封装DTO
 *
 * @author qianfg
 * @date 2021/12/12 下午5:59
 * @Email: 287541326@qq.com
 */
@Data
@ApiModel("返回数据封装DTO")
public class BaseDataResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("状态码")
    private String code;

    @ApiModelProperty("消息")
    private String message;

    @ApiModelProperty("返回数据")
    private T data;

    public BaseDataResult() {
        this.code = ResultCodeCst.SUCCESS;
    }

    public BaseDataResult(String code) {
        this.code = code;
    }

    public BaseDataResult(T data) {
        this.code = ResultCodeCst.SUCCESS;
        this.data = data;
    }

}

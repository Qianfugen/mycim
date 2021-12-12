package fun.qianfg.controller;

import fun.qianfg.cst.ResultCodeCst;
import fun.qianfg.dto.BaseDataResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Function:所有controller层父类，全局异常捕获
 *
 * @author qianfg
 * @date 2021/12/12 下午5:59
 * @Email: 287541326@qq.com
 */
public class BaseController {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    protected BaseDataResult exceptionHandler(Exception error) {
        BaseDataResult<Object> result = new BaseDataResult<>(ResultCodeCst.FAILED);
        result.setMessage(error.getMessage());
        return result;
    }

    protected <T> BaseDataResult<T> data(T data) {
        return new BaseDataResult<>(data);
    }

}

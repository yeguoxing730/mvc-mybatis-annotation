package com.mvc.exception;

import com.mvc.utils.LoggerHelper;
import com.mvc.utils.Utils;
import com.mvc.vo.Return;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Return jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        //记录错误日志到本地日志系统
        LoggerHelper.error(Utils.getExceptionTrace(e));
        // e.printStackTrace();
        //返回友好的客户端response
        Return rs = new Return();
        rs.setReturncode(0);
        rs.setMessage(Utils.getExceptionTrace(e));
        return rs;
    }


}

package com.opzpy123.zweb3.core.conf;

import com.opzpy123.zweb3.core.exception.WebException;
import com.opzpy123.zweb3.core.vo.resp.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 自定义异常处理
 */
@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(value = WebException.class)
    @ResponseBody
    public R exceptionHandler(WebException e) {
        return R.error(e.getMessage());
    }
}

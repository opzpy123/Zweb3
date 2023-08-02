package com.opzpy123.zweb3.core.vo.resp;

import com.opzpy123.zweb3.core.constant.WebStateConst;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class R<T> {
    private String state;
    private String message;
    private List<String> log;
    private T data;

    public static <T> R<T> success(T dto) {
        R<T> response = new R<>();
        response.setData(dto);
        response.setState(WebStateConst.PROCESS_RESULT_SUCCESS);
        return response;
    }

    public static R error(String errorInfo) {
        R<Void> response = new R<>();
        response.setMessage(errorInfo);
        response.setState(WebStateConst.PROCESS_RESULT_ERROR);
        return response;
    }
}

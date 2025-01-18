package com.yy.linxiweb.bo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Schema(description = "响应消息体")
@Data
public class Response<T> implements Serializable {

    @Schema(description = "消息码")
    private int code;

    @Schema(description = "消息")
    private String msg;

    @Schema(description = "数据")
    private T data;

    @Schema(description = "其他自定义信息")
    private Map<String, Object> map = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getMap() {
        return map;
    }
}

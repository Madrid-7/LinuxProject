package com.zxf.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ：ZXF
 * @program: spring-boot
 * @description:
 * @date ：2021-03-29 16:12
 */

@Getter
@Setter
@ToString
public class Response {
    private boolean success;  // 操作是否成功
    private String code;   // 错误码
    private String message;  // 错误信息
    private Object data;   // 数据
    private String stackTrack;  // 堆栈信息
}

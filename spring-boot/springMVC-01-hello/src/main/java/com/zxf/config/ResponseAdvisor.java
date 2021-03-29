package com.zxf.config;

import com.zxf.model.Response;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author ：ZXF
 * @program: spring-boot
 * @description:
 * @date ：2021-03-29 15:44
 */

// 返回信息的 统一格式化
@ControllerAdvice
public class ResponseAdvisor implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        // 返回 true, 表示响应数据时，先执行 beforeBodyWrite， false 则不执行
        // 获取请求方法对象，判断 ControllerAdvice 方法上是否有 @ResponseBody
        ResponseBody annotation = methodParameter.getMethod().getAnnotation(ResponseBody.class);
        if (annotation == null) {
            return false;
        }
        return true;
    }

    // body 为请求方法返回的对象
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        Response resp = new Response();
        resp.setSuccess(true);
        resp.setData(o);
        return resp;
    }
}

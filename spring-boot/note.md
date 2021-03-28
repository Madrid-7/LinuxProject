
springboot 会默认将src/main/resources下的
  1. /public
  2. /static  静态资源
  3. /templates  模板资源
  4. 其他 

会自动加载

favicon.ico会自动加载为web项目，网站url的图片

---
### 请求相关
- @RequestMapping("xxx")
    - 可以使用在类、方法上，表示客户端请求的配置（包括uri，请求方法，数据类型）
    - @RequestParam("xxx")设置Request body的内容参数，接受的数据格式
        - 不加注解，默认映射属性（变量名）
        - 类型可以是封装数据类型、自定义类型
        - 请求数据中，键和自定义类型属性匹配
        - 只接收url中的数据 + x-www-form-urlencoded(表单默认形式) + from-data
- @RequestBody: 设置请求体的 Content-Type 为 application/json
### 响应相关
- @RestController == @Controller + @ResponseBody (所有方法默认都有)
- @ResponseBody：返回的 Content-Type 响应头为 application/json
    - 不带 @ResponseBody 注解，需要返回字符串，表示静态资源路径
    
---
统一的拦截器：
- @Configuration 
  - implements WebMvcConfigurer
  - @Override
    public void addInterceptors(InterceptorRegistry registry)
  -   Interceptor implements HandlerInterceptor
    
统一的异常处理：
- @ControllerAdvice + ExceptionHandler(Exception.class) 拦截Controller 方法抛出的异常


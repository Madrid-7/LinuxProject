## 常用依赖
```xml
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>5.2.3.RELEASE</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>5.2.3.RELEASE</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.2.3.RELEASE</version>
        </dependency>

        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
```

## 自动装配配置文件
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>
</beans>
```

## 注解说明

- @Autowired : 自动装配 通过类型，名字 如果不唯一，可用 @Qualifier(value = "xx") 来指定
-   @Autowired(required = false) required == false 则说明这个对象可以为 null
- @Resource : 通过名字，类型 自动装配
---
- @Component : 组件的意思， 放在类上 说明这个类被管理了
  @Value("xxx") 用来注释属性
  1. dao -> @Repository
  2. service -> @Service
  3. controller -> @Controller
     </br>这四个注解功能一样
     
- @Scope("xxx") : 作用域
---
- @Configuration
  - 这个也会被 Spring 托管，注册到容器中，他本来就是一个@Component
  - @Configuration 就是代表一个配置类， 相当于 beans.xml
-  @ComponentScan("com.zxf.pojo")
-  @Import(con2.class)

- @Bean 
  - 注册一个 bean
  -  方法的名字就相当于 bean 标签中的 id 属性
  -    这个方法的返回值，就相当于 bean 标签中的 class属性
    
- 使用了配置类的方式，就要用 AnnotationConfigApplicationContext 获取
  - ApplicationContext context = new AnnotationConfigApplicationContext(con.class);

---
静态代理模式的好处：
- 可以使真实角色的操作更加纯粹！不用去关注一些公共的业务
- 公共业务交给了代理角色，实现业务分工
- 公共业务发生扩展的时候，方便集中管理

缺点：
- 一个真实的角色就会产生一个代理角色; 代码量会翻倍--开发效率会降低

---
## 动态代理

需要了解两个类：
  1. Proxy：生成得到代理类的静态方法
  2. InvocationHandler： 调用处理程序

动态代理的好处：
- 一个代理类代理的就是一个接口，一般就是对应的一类业务


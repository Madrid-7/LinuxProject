package com.zxf.tomcat;

import com.zxf.standard.Servlet;
import com.zxf.standard.ServletException;

import java.io.IOException;
import java.util.*;

public class Context {
    private final ConfigReader reader;
    private final String name;
    private Config config;
    // 每个 Context 有自己的类加载器
    // 我们平时写的 web 应用中的代码，都是由自己 Context 的类加载器进行加载，互不干扰
    private final ClassLoader webappClassLoader = Context.class.getClassLoader();

    public Context(ConfigReader reader, String name) {
        this.reader = reader;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void readConfigFile() throws IOException {
        this.config = reader.read(name);
    }

    List<Class<?>> servletClassList = new ArrayList<>();
    public void loadServletClasses() throws ClassNotFoundException {
        Set<String> servletClassNames = new HashSet<>(config.servletNameToServletClassNameMap.values());
        for (String servletClassName : servletClassNames) {
            Class<?> servletClass = webappClassLoader.loadClass(servletClassName);
            servletClassList.add(servletClass);
        }
    }

    List<Servlet> servletList = new ArrayList<>();
    public void instantiateServletObjects() throws IllegalAccessException, InstantiationException {
        for (Class<?> servletClass : servletClassList) {
            Servlet servlet = (Servlet)servletClass.newInstance();  // 调用该类的无参构造方法，进行实例化对象
            servletList.add(servlet);
        }
    }

    public void initServletObjects() throws ServletException {
        for (Servlet servlet : servletList) {
            servlet.init();
        }
    }

    public void destroyServlets() {
        for (Servlet servlet : servletList) {
            servlet.destroy();
        }
    }

    public Servlet get(String servletPath) {
        String servletName = config.urlToServletNameMap.get(servletPath);
        String servletClassName = config.servletNameToServletClassNameMap.get(servletName);
        for (Servlet servlet : servletList) {
            String currentServletClassName = servlet.getClass().getCanonicalName();
            if (currentServletClassName.equals(servletClassName)) {
                return servlet;
            }
        }

        return null;
    }
}

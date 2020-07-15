package name.wwl.demo.study.design.pattern.proxy.spring;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
public class TimeProxy {

    @Before("execution(void name.wwl.demo.study.design.pattern.proxy.spring.Tank.move())")
    public void before() {
        System.out.println("method start.." + System.currentTimeMillis());
    }

    @After("execution(void name.wwl.demo.study.design.pattern.proxy.spring.Tank.move())")
    public void after() {
        System.out.println("method stop.." + System.currentTimeMillis());
    }

}

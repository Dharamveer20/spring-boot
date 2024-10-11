package com.in28minutes.learnspringaop.aspects;
import org.aspectj.lang.annotation.Pointcut;
public class CommonPointcutConfig {
//    Now we can call this function with the annotation @After, @Before,etc
    @Pointcut("execution(* com.in28minutes.learnspringaop.aopexample.business.*.*(..))")
    public void businessPackageConfig(){}
}

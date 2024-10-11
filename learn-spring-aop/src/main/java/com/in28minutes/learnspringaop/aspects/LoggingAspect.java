package com.in28minutes.learnspringaop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect //  @Aspect tells Spring that this class contains special code (called an aspect) that we want to apply to different parts of your application.
public class LoggingAspect {
    Logger logger = LoggerFactory.getLogger(getClass());

//    When to call (here we are saying before invoking any function from business package (wherever it's function is called) call this logMethodCall function)
    @Before("execution(* com.in28minutes.learnspringaop.aopexample.business.*.*(..))")
    //    -----------------------------------------       OR             ---------------------------------
//    @Before("com.in28minutes.learnspringaop.aspects.CommonPointcutConfig.businessPackageConfig()")
//    What to call (here we are saying call logMethodCall function)
    public void logMethodCall(JoinPoint joinPoint){ // JoinPoint returns the method name which was invoked.
        logger.info("Before Method is called - {} ", joinPoint);
//        Consider if calculateMin function was called but before invoking that function logMethodCall function wil be invoked.
//        Output of this function call below,
//        Method is called - execution(int com.in28minutes.learnspringaop.aopexample.business.BusinessService1.calculateMin())
//        Now calculateMin() function will be called wherever it was called.
    }

//    @After ---> intercept after invoking a function

//    AfterThrowing: We must 2 para to it, 1st pointcut (when to call), 2nd throwing which stores the exception
    @AfterThrowing(
            pointcut = "execution(* com.in28minutes.learnspringaop.aopexample.business.*.*(..))", // Point cut
            throwing = "exception" // This para will store the exception thrown by the method.
    )
    public void logMethodCallAfterThrowing(JoinPoint joinPoint, Exception exception){ // exception stores the exception thrown by the function
        logger.info("After throwing: Exception in method {} with message {}", joinPoint, exception.getMessage());
    }

//    AfterReturning: We must 2 para to it, 1st pointcut (when to call), 2nd returning which stores the value returned by the function
    @AfterReturning(
            pointcut = "execution(* com.in28minutes.learnspringaop.aopexample.business.*.*(..))", // Point cut
            returning = "resultValue" // This para will store the exception thrown by the method.
    )
    public void logMethodCallAfterReturning(JoinPoint joinPoint, Object resultValue){ // exception stores the exception thrown by the function
        logger.info("After Returning: Value in method {} with value {}", joinPoint,resultValue);
    }


    @Around("execution(* com.in28minutes.learnspringaop.aopexample.business.*.*(..))")
    public Object logMethodCallAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        TASK BEFORE EXECUTION OF THE FUNCTION
//        For eg, Start of timer
        long startMill = System.currentTimeMillis();

//        Executing the function and storing the return value in returnValue
        Object returnValue = proceedingJoinPoint.proceed();

//        TASK AFTER EXECUTION OF THE FUNCTION (Note the control is still in hand of advice function).
//        Stopping the Timer
        long endMill = System.currentTimeMillis();

        long executionTime = endMill - startMill;
        logger.info("Around: Method {}, executed in {} ms ", proceedingJoinPoint, executionTime);

//       ab jis ke method ke call hone se ye call hua hai. usko call ko ye return krdo.
        return returnValue;
    }
}

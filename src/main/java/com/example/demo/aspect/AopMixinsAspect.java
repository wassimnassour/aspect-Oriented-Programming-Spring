package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//interface Audit {
//    String getName();
//    long getStartTime();
//    long getEndTime();
//
//    void setStartTime(long startTime);
//    void setEndTime(long endTime);
//    void setName(String name);
//}
//
//
//class AuditableImpl implements Audit {
//    private String name;
//    private long startTime;
//    private long endTime;
//
//    public AuditableImpl(String name, long startTime, long endTime) {
//        this.name = name;
//        this.startTime = startTime;
//        this.endTime = endTime;
//    }
//
//    public String getName() {
//        return this.name;
//    }
//
//    public long getStartTime() {
//        return this.startTime;
//    }
//
//    public long getEndTime() {
//        return this.endTime;
//    }
//
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setStartTime(long startTime) {
//        this.startTime = startTime;
//    }
//
//    public void setEndTime(long endTime) {
//        this.endTime = endTime;
//    }
//
//}
//

@Aspect
@Component
public class AopMixins {


//    @DeclareParents(value = "com.example.demo.service.UserService+", defaultImpl = AuditableImpl.class)
//    private Audit audit;


//    @Around("logPointcut()")
    @Before("logPointcut()")
    public void audit(ProceedingJoinPoint joinPoint) throws Throwable {

         System.out.println("Around Method: With Mixin  " + joinPoint.getSignature().getName());
//        audit.setStartTime(System.currentTimeMillis());
//        audit.setName(joinPoint.getSignature().getName());
//        System.out.println("This is AuditPointcut" + audit.getName() + audit.getStartTime() + audit.getEndTime());
//        return joinPoint.proceed();
    }





    @Pointcut("execution(* com.example.demo.service.UserService.getUserById(..))")
    public void logPointcut() { }
//
//    @Pointcut("execution(* com.example.demo.service.UserService.getUserById(..))")
//    public void logPointcut() { }

    @Pointcut("execution(* com.example.demo.service.UserService.*(..))")
    public void AuditPointcut() {
    }
}

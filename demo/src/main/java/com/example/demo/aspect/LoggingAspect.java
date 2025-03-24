package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // ✅ Fix pointcut name to match the method name in CourseService
    @Pointcut("execution(* com.examly.springapp.service.CourseService.getAllCourses(..))")
    public void getAllCoursesMethod() {
    }

    // ✅ Fix @Before pointcut reference
    @Before("getAllCoursesMethod()")
    public void logBefore() {
        logger.info("Fetching all courses...");
    }

    // ✅ Fix return type to Set instead of List
    @AfterReturning(pointcut = "getAllCoursesMethod()", returning = "result")
    public void logAfterReturning(Object result) {
        logger.info("Successfully fetched all courses, count: {}", ((Set<?>) result).size());
    }
}

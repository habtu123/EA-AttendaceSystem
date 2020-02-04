package edu.miu.cs.cs544.ether.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class ProjectLogger {

    private Logger log = LoggerFactory.getLogger(getClass());

    @AfterReturning(pointcut = "execution(* edu.miu.cs.cs544.ether.service..*.*(..))", returning = "result")
    public void logMethodAccessAfter(JoinPoint joinPoint, Object result)
    {
        if (result instanceof List) {
            List<?> resultList = (List<?>) result;
            log.info("END " + " method:" + joinPoint.getSignature().getName() + ": " + resultList.size());
        } else {// The result isn't a list but is a single object
            log.info("END " + " method:" + joinPoint.getSignature().getName() + ": " + 1);
        }
    }

}

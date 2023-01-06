package tn.esprit.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {
	@Around("execution(* tn.esprit.Services.*.*(..))")
    public void profile(ProceedingJoinPoint pjp) throws Throwable {
            long start = System.currentTimeMillis();
            pjp.proceed();
            long elapsedTime = System.currentTimeMillis() - start;
            log.info("test");
            log.info("Method execution time: " + elapsedTime + " milliseconds.");
    }
}

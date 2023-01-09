package tn.esprit.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class Aop {
	@Around("execution(* tn.esprit.services.*.ModifierImc(..))")
    public void profile(ProceedingJoinPoint pjp) throws Throwable {
           
            log.info("calcule");
    }
}

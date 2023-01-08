package tn.esprit.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@org.aspectj.lang.annotation.Aspect
@Slf4j
public class Aspect {
	  @AfterReturning("execution(* tn.esprit.Services.*.*(String))")
	    public void logMethodEnd(JoinPoint joinPoint) {
	        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	        log.info("signature  : "+signature.getMethod().getName());
	    }
}

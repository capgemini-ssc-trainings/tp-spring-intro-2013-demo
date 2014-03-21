package app.server.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

//[ Aufgabe 6.2
@Component("profilingAspect")
//] Aufgabe 6.2  Make a Spring bean using annotation
//[ Aufgabe 6.3
@Aspect
//] Aufgabe 6.3  Make an aspect using @Aspect annotation
public class ProfilingAspect {
	final Logger logger = LoggerFactory.getLogger(ProfilingAspect.class);

	//[ Aufgabe 6.4
	@Pointcut("execution(* app.server.service.BookService.*(..))")
	public void profiling() {
	}
	//] Aufgabe 6.4  Implement the pointcut enabling this aspect for all methods of the BookService using the @Pointcut annotation
	
	//[ Aufgabe 6.5
	@Around("profiling()")
	//] Aufgabe 6.5  Enable this method as the around advice using the @Around annotation
	public Object profile(ProceedingJoinPoint joinpoint) throws Throwable {
		logger.info("Profiling of " + joinpoint.getSignature().toShortString()
				+ " started");
		StopWatch sw = new StopWatch(getClass().getSimpleName());
		
		try {
			logger.info("Methd " + joinpoint.getSignature().toShortString()
					+ " starts");
			sw.start(joinpoint.getSignature().getName());
		
			return joinpoint.proceed();
		
		} finally {
			logger.info("Methd " + joinpoint.getSignature().toShortString()
					+ " finished");
			sw.stop();
			logger.info(sw.prettyPrint());
			logger.info("Profiling of "
					+ joinpoint.getSignature().toShortString()
					+ " finished");
		}
	}

}

package aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectConfigCglib {
	@Pointcut("execution(* aop..service.WorkService.*(..))")
	private void pointCut() {
	}

	/**
	 * 环绕通知
	 */
	@Around("pointCut()")
	public Object testAround(ProceedingJoinPoint joinPoint) throws Throwable {
		Object obj = new Object();
		String className = null;
		String methodName = null;
		try {
			className = joinPoint.getTarget().getClass().getSimpleName();
			methodName = joinPoint.getSignature().getName();
			System.out.println(className + "." + methodName + " start !"); //进入的记录类名+函数名
			obj = joinPoint.proceed();
		} catch (Exception e) {
			System.out.println(" error Message : " + e.getMessage()); //记录报错信息
			e.printStackTrace();
		}
		System.out.println(className + "." + methodName + " end !"); //记录结束的类名+函数名
		return obj;
	}
}

package com.app.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointcutDefinition {

	@Pointcut("within(com.app.aop.web..*)")
	public void webLayer() {
	}

	@Pointcut("within(com.app.aop.service..*)")
	public void serviceLayer() {
	}

	@Pointcut("within(com.app.aop.dao..*)")
	public void dataAccessLayer() {
	}
	
	/*sample pointcut expression
	 * 1)@Pointcut("execution(* transfer(..))")  // match any method with name transfer
	 * @Pointcut("execution(public * transfer(..))")  // match any public method with name transfer
	 * @Pointcut("execution(public * *(..))")  // match any public method with name 
	 * 
	 * execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern)
          throws-pattern?)
	 * execution(* set*(..)) any method which name start from set
	 * execution(* com.xyz.service.*.*(..))   any method defined in service package
	 * execution(* com.xyz.service..*.*(..))  any method defined in the service package or a sub-package:
	 * 
	 * 
	 * within(com.xyz.service..*) any join point (method execution only in Spring AOP) within the service package or a sub-package
	 * 
	 * this(com.xyz.service.AccountService) any join point (method execution only in Spring AOP) where the proxy implements the AccountService interface:
	 * 
	 * target(com.xyz.service.AccountService) any join point (method execution only in Spring AOP) where the target object implements the AccountService interface:
	 * 
	 * @target(org.springframework.transaction.annotation.Transactional) any join point (method execution only in Spring AOP) where the target object has an @Transactional annotation
	 * 
	 * args(java.io.Serializable,..) any parameter which have serializable
	 * 
	 * @annotation(org.springframework.transaction.annotation.Transactional)  any join point (method execution only in Spring AOP) where the target executing method has an @Transactional annotation:
	 * 
	 * @args(com.xyz.security.Classified)  runtime type of the argument passed has the @Classified annotation:
	 * 
	 * bean(tradeService) ,bean(*Service) -> any join point (method execution only in Spring AOP) on a Spring bean named 'tradeService'
	 * 
	 */

}

package com.app.aop.security;

import org.aspectj.lang.annotation.Aspect;
//https://dzone.com/articles/spring-aop-security
@Aspect
public class SecurityInterceptor {/*
 private static final Logger LOGGER = LoggerFactory.getLogger(SecurityInterceptor.class);
 
 public SecurityInterceptor() {
  LOGGER.debug("Security Interceptor created");
 }
 
 @Autowired
 private UserService userService;
 
 @Pointcut("execution(pl.grzejszczak.marcin.aop.ui.UIComponent pl.grzejszczak.marcin.aop.ui.UIFactory.createComponent(..))")
 private void getComponent(ProceedingJoinPoint thisJoinPoint) {
 }
 
 @Around("getComponent(thisJoinPoint)")
 public UIComponent checkSecurity(ProceedingJoinPoint thisJoinPoint) throws Throwable {
  LOGGER.info("Intercepting creation of a component");
 
  Object[] arguments = thisJoinPoint.getArgs();
  if (arguments.length == 0) {
   return null;
  }
 
  Annotation annotation = checkTheAnnotation(arguments);
  boolean securityAnnotationPresent = (annotation != null);
 
  if (securityAnnotationPresent) {
   boolean userHasRole = verifyRole(annotation);
   if (!userHasRole) {
    LOGGER.info("Current user doesn't have permission to have this component created");
    return null;
   }
  }
  LOGGER.info("Current user has required permissions for creating a component");
  return (UIComponent) thisJoinPoint.proceed();
 }
 
 *//**
  * Basing on the method's argument check if the class is annotataed with
  * {@link SecurityAnnotation}
  *
  * @param arguments
  * @return
  *//*
 private Annotation checkTheAnnotation(Object[] arguments) {
  Object concreteClass = arguments[0];
  LOGGER.info("Argument's class - [{}]", new Object[] { arguments });
  AnnotatedElement annotatedElement = (AnnotatedElement) concreteClass;
  Annotation annotation = annotatedElement.getAnnotation(SecurityAnnotation.class);
  LOGGER.info("Annotation present - [{}]", new Object[] { annotation });
  return annotation;
 }
 
 *//**
  * The function verifies if the current user has sufficient privilages to
  * have the component built
  *
  * @param annotation
  * @return
  *//*
 private boolean verifyRole(Annotation annotation) {
  LOGGER.info("Security annotation is present so checking if the user can use it");
  SecurityAnnotation annotationRule = (SecurityAnnotation) annotation;
  List<Role> requiredRolesList = Arrays.asList(annotationRule.allowedRole());
  Role userRole = userService.getUserRole();
  return requiredRolesList.contains(userRole);
 }
*/}
package annotation;

import java.lang.annotation.Annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsCorrectAddressValidator<T extends BaseBean> implements ConstraintValidator<RequestBeanValidator, T> {

	public void initialize(RequestBeanValidator constraintAnnotation) {

	}

	@Override
	public boolean isValid(T value, ConstraintValidatorContext context) {
		Annotation []  annotations=value.getClass().getAnnotations();
		annotations.getClass().getName();
		return false; 
	}

}

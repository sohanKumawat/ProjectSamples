package annotation;

import javax.validation.ConstraintValidator;

public interface CustomContrantsValidator<T extends BaseBean> extends ConstraintValidator<RequestBeanValidator, T> {

}

package com.rogov.labrary.validator;

import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public interface BookValidator<T> extends Validator {

    @Override
    default public boolean supports(Class<?> aClass) {
        Class<?> clazz = GenericTypeResolver.resolveTypeArgument(getClass(), BookValidator.class);
        return clazz.isAssignableFrom(aClass);
    }

    @Override
    default public void validate(Object o, Errors errors) {
        check((T) o, errors);
    }

    void check(T target, Errors errors);
}

package com.inditex.retail.shopprice.module.shared.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {DateTimeValidatorImpl.class})
@Documented
public @interface DateTimeValidator {

    String pattern() default "yyyy-MM-dd HH:mm:ss";

    String message() default " value must contain a date and time with 'yyyy-MM-dd HH:mm:ss' pattern (2020-09-17 15:15:30).";

    String paramName() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

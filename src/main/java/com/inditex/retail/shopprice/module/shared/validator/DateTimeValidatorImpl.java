package com.inditex.retail.shopprice.module.shared.validator;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;
import org.hibernate.validator.internal.metadata.descriptor.ConstraintDescriptorImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeValidatorImpl implements ConstraintValidator<DateTimeValidator, String> {

    private static String getAttribute(final ConstraintValidatorContext context, final String attributeName) {
        return ((ConstraintDescriptorImpl) ((ConstraintValidatorContextImpl) context)
                .getConstraintDescriptor()).getAnnotationDescriptor().getAttributes().get(attributeName).toString();
    }

    public final boolean isValid(final String value, final ConstraintValidatorContext context) {

        if (StringUtils.isNotBlank(value)) {
            final DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern(getAttribute(context, "pattern"));

            try {
                ZonedDateTime.parse(value.trim(), formatter);
            } catch (final Exception e) {
                context.disableDefaultConstraintViolation();

                final String paramName = getAttribute(context, "paramName");
                final String message = getAttribute(context, "message");

                context.buildConstraintViolationWithTemplate(paramName + message).addConstraintViolation();
                return false;
            }
        }

        return true;
    }
}
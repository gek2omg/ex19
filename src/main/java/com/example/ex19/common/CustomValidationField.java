package com.example.ex19.common;

import org.springframework.validation.FieldError;

import java.util.Collection;
import java.util.List;
import java.util.TreeMap;

public class CustomValidationField {

    public static Collection<CustomFieldError> reBuildErrors(final List<FieldError> errors) {
        TreeMap<String, CustomFieldError> hashMap = new TreeMap<>(); // 정렬되어서 들어가게

        for (final FieldError error : errors)
            hashMap.put(
                    error.getField() + error.getCode(),
                    new CustomFieldError(
                            error.getCode(),
                            error.getField(),
                            error.getDefaultMessage(),
                            error.getRejectedValue()
                    )
            );

        return hashMap.values();
    }

    public static class CustomFieldError {
        public final String code;
        public final String field;
        public final String defaultMessage;
        public final Object rejectedValue;

        public CustomFieldError(String code, String field, String defaultMessage, Object rejectedValue) {
            this.code = code;
            this.field = field;
            this.defaultMessage = defaultMessage;
            this.rejectedValue = rejectedValue;
        }
    }
}

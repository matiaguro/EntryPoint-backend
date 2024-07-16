package com.techar.EntryPointBackend.core.models.validuser;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidUser {
    boolean enabled() default true;
}

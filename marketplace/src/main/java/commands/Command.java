package commands;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(value=RUNTIME)
@Target(value= {ElementType.TYPE, ANNOTATION_TYPE})
public @interface Command {
     String command() default "";
}

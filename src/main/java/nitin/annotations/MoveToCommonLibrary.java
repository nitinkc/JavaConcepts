package nitin.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** Annotation to mark classes or methods that can be moved to a common library. */
@Retention(RetentionPolicy.SOURCE) // discarded by the compiler.
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface MoveToCommonLibrary {
    String description() default "";
}

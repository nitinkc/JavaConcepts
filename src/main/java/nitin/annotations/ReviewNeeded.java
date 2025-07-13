package nitin.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** This annotation marks classes or methods that need to be reviewed. */
@Target({
    ElementType.LOCAL_VARIABLE,
    ElementType.FIELD,
    ElementType.TYPE,
    ElementType.METHOD,
    ElementType.PACKAGE
})
@Retention(RetentionPolicy.SOURCE) // discarded by the compiler.
public @interface ReviewNeeded {

    String description() default "";

    /**
     * The reviewers assigned to this class/method.
     *
     * @return the list of reviewers
     */
    String[] reviewers() default {"Nitin"}; // Using an array for compatibility
}

package nitin.annotations.run;

import java.lang.annotation.*;

/**
 * Created by nitin on Monday, March/30/2020 at 11:51 PM
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Documentation {
    String author() default "Nitin K C";
    String date();
    int currentRevision() default 1;
    String lastModified() default "N/A";
    String lastModifiedBy() default "N/A";
    String[] reviewers();// Note use of array
}

package nitin.annotations;

import java.lang.annotation.Documented;

/**
 * Created by nitin on Monday, March/30/2020 at 11:51 PM
 */
@Documented
public @interface ClassWriter {
    String author() default "Nitin K C";

    String date();

    int currentRevision() default 1;

    String lastModified() default "N/A";

    String lastModifiedBy() default "N/A";

    // Note use of array
    String[] reviewers();
}

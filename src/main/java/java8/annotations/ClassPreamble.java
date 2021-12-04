package java8.annotations;

/**
 * Created by nitin on Monday, March/30/2020 at 11:51 PM
 */
public @interface ClassPreamble {
    String author();
    String date();
    int currentRevision() default 1;
    String lastModified() default "N/A";
    String lastModifiedBy() default "N/A";
    // Note use of array
    String[] reviewers();
}

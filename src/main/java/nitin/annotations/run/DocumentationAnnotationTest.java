package nitin.annotations.run;

import lombok.ToString;

@Documentation(
        date = "Jan 02 2022",
        lastModified = "2024-08-22",
        lastModifiedBy = "John Doe",
        reviewers = {"Alice", "Bob"}
)
@ToString
public class DocumentationAnnotationTest {

    public static void main(String[] args) {
        System.out.println(new DocumentationAnnotationTest().toString());
    }
}

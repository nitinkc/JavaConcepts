package nitin.annotations.run;

public class AnnotationPrinter {
    public static void main(String[] args) {
        //Via reflection, Class under test
        Class<?> clazz = DocumentationAnnotationTest.class;

        // Check if the class is annotated with @ClassWriter
        if (clazz.isAnnotationPresent(Documentation.class)) {
            // Retrieve the annotation
            Documentation annotation = clazz.getAnnotation(Documentation.class);

            // Print the annotation values
            System.out.println("Author: " + annotation.author());
            System.out.println("Date: " + annotation.date());
            System.out.println("Current Revision: " + annotation.currentRevision());
            System.out.println("Last Modified: " + annotation.lastModified());
            System.out.println("Last Modified By: " + annotation.lastModifiedBy());

            // Print reviewers
            System.out.print("Reviewers: ");
            for (String reviewer : annotation.reviewers()) {
                System.out.print(reviewer + " ");
            }
            System.out.println();
        } else {
            System.out.println("No @ClassWriter annotation present.");
        }
    }
}

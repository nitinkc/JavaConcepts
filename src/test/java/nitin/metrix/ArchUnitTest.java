package nitin.metrix;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.library.Architectures;
import org.junit.jupiter.api.Test;

public class ArchUnitTest {

    @Test
    void testArch() {
        JavaClasses jc = new ClassFileImporter().importPackages("com.nitin");

        Architectures.LayeredArchitecture arch;
        //        arch = layeredArchitecture()
        //                // Define layers
        //                .layer("Presentation").definedBy("..presentation..")
        //                .layer("Service").definedBy("..service..")
        //                .layer("Persistence").definedBy("..persistence..")
        //                // Add constraints
        //                .whereLayer("Presentation").mayNotBeAccessedByAnyLayer()
        //                .whereLayer("Service").mayOnlyBeAccessedByLayers("Presentation")
        //                .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Service");

        // arch.check(jc);
    }
}

package nitin.metrix;


import jdepend.framework.JDepend;
import jdepend.framework.JavaPackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class DistanceFromMainSequenceFitnessFunction {

    private JDepend jdepend = new JDepend();

    @BeforeEach
    void init() throws IOException {
        jdepend = new JDepend();
        jdepend.addDirectory("build/classes/java/main");
    }
    @Test
    void testAllPackages() {
        Collection packages = jdepend.analyze();
        assertEquals("Cycles exist", false, jdepend.containsCycles());
    }

    @Test
    void allPackages(){
        double ideal = 0.0;
        double tolerance = 0.5; // project-dependent
        Collection packages = jdepend.analyze();
        Iterator iter = packages.iterator();
        while (iter.hasNext()) {
            JavaPackage p = (JavaPackage)iter.next();
            Assertions.assertEquals(ideal, p.distance(), tolerance, "Distance exceeded: " + p.getName());
        }
    }
}

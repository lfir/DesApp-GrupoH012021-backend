package ar.edu.unq.desapp.grupoh.architecture;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchitectureTest {
	@Test
    public void serviceClassesAreAnnotatedWithServiceAnnotationAndResideInServicePackage() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("ar.edu.unq.desapp");
    
        ArchRule rule = classes().that().haveNameMatching(".*Service")
        					.should().beAnnotatedWith(Service.class)
        					.andShould().resideInAPackage("ar.edu.unq.desapp.grupoh.service");
    
        rule.check(importedClasses);
    }
}

package dev.zevolution.pocquarkusjob.architecture;

import com.tngtech.archunit.core.domain.JavaMember;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.conditions.ArchConditions;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

@AnalyzeClasses(packages = "dev.zevolution")
public class InjectionTest {

    @ArchTest
    static ArchRule injectAnnotationFieldValidator = ArchRuleDefinition
            .noFields().should(beAnnotatedWithAnInjectionAnnotation())
            .because("field injection is considered harmful; use constructor injection instead; see https://stackoverflow.com/q/39890849 for detailed explanations");

    @ArchTest
    static ArchRule injectAnnotationMethodValidator = ArchRuleDefinition
            .noMethods().should(beAnnotatedWithAnInjectionAnnotation())
            .because("method injection is considered harmful; use constructor injection instead; see https://stackoverflow.com/q/39890849 for detailed explanations");

    private static <T extends JavaMember> ArchCondition<T> beAnnotatedWithAnInjectionAnnotation() {
        ArchCondition<T> annotatedWithSpringAutowired = ArchConditions.beAnnotatedWith("org.springframework.beans.factory.annotation.Autowired");
        ArchCondition<T> annotatedWithJakartaInject = ArchConditions.beAnnotatedWith("javax.inject.Inject");
        return annotatedWithSpringAutowired.or(annotatedWithJakartaInject);
    }

}

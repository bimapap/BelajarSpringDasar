package bimapap.spring.core.application;

import bimapap.spring.core.data.Foo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

public class WithoutSpringBootTest {

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigReactiveWebApplicationContext(FooApplication.class);
        context.registerShutdownHook();
    }

    @Test
    void testFoo() {
        Foo foo = context.getBean(Foo.class);

    }
}

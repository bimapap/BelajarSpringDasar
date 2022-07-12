package bimapap.spring.core;

import bimapap.spring.core.data.Bar;
import bimapap.spring.core.data.Foo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

public class ImportTest {

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigReactiveWebApplicationContext(MainConfiguration.class);
        context.registerShutdownHook();
    }

    @Test
    void testImport() {
        Foo foo = context.getBean(Foo.class);
        Bar bar = context.getBean(Bar.class);
    }
}

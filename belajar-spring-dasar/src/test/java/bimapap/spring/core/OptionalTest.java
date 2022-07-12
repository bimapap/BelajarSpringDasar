package bimapap.spring.core;

import bimapap.spring.core.data.Foo;
import bimapap.spring.core.data.FooBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

public class OptionalTest {

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigReactiveWebApplicationContext(OptionalConfiguration.class);
        context.registerShutdownHook();
    }

    @Test
    void testOptional() {
        Foo foo = context.getBean(Foo.class);
        FooBar fooBar = context.getBean(FooBar.class);

        Assertions.assertNull(fooBar.getBar());
        Assertions.assertSame(foo, fooBar.getFoo());
    }
}

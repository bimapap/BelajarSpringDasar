package bimapap.spring.core;

import bimapap.spring.core.data.Foo;
import bimapap.spring.core.processor.FooBeanFactoryPostProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class BeanFactoryPostProcessorTest {

    @Configuration
    @Import(FooBeanFactoryPostProcessor.class)
    public static class TestConfiguration{

    }

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigReactiveWebApplicationContext(TestConfiguration.class);
        context.registerShutdownHook();
    }

    @Test
    void testBeanFactoryPostProcessor() {
        Foo foo = context.getBean(Foo.class);
        Assertions.assertNotNull(foo);
    }
}

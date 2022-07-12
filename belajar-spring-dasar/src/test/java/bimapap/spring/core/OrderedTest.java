package bimapap.spring.core;

import bimapap.spring.core.data.Car;
import bimapap.spring.core.processor.IdGeneratorBeanPostProcessor;
import bimapap.spring.core.processor.PrefixIdGeneratorBeanPostProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class OrderedTest {

    @Configuration
    @Import({
            Car.class,
            IdGeneratorBeanPostProcessor.class,
            PrefixIdGeneratorBeanPostProcessor.class
    })
    public static class TestConfiguration{

    }

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigReactiveWebApplicationContext(TestConfiguration.class);
        context.registerShutdownHook();
    }

    @Test
    void testCar() {
        Car car = context.getBean(Car.class);
        Assertions.assertNotNull(car.getId());
        Assertions.assertTrue(car.getId().startsWith("BIMA-"));
    }
}

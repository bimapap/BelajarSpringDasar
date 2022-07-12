package bimapap.spring.core;

import bimapap.spring.core.service.AuthService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class AwareTest {
    
    @Configuration
    @Import({
            AuthService.class
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
    void testAware() {
        AuthService authService = context.getBean(AuthService.class);
        Assertions.assertEquals("bimapap.spring.core.service.AuthService", authService.getBeanName());
        Assertions.assertNotNull(authService.getApplicationContext());
        Assertions.assertSame(context,authService.getApplicationContext());
    }
}

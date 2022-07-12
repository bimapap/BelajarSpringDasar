package bimapap.spring.core;

import bimapap.spring.core.listener.LoginAgainSuccessListener;
import bimapap.spring.core.listener.LoginSuccessListener;
import bimapap.spring.core.listener.UserListener;
import bimapap.spring.core.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class EventListenerTest {

    @Configuration
    @Import({
            UserService.class,
            LoginSuccessListener.class,
            LoginAgainSuccessListener.class,
            UserListener.class
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
    void testEvent() {
        UserService userService = context.getBean(UserService.class);
        userService.login("bima","bima");
        userService.login("bima","bimapap");
        userService.login("bima","bimapap2");
    }
}

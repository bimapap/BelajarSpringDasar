package bimapap.spring.core;

import bimapap.spring.core.service.MerchantService;
import bimapap.spring.core.service.MerchantServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

public class InheritanceTest {

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigReactiveWebApplicationContext(InheritanceConfiguration.class);
        context.registerShutdownHook();
    }

    @Test
    void testInheritance() {
        MerchantService merchantService = context.getBean(MerchantService.class);
        MerchantServiceImpl merchantServiceImpl = context.getBean(MerchantServiceImpl.class);

        Assertions.assertSame(merchantService,merchantServiceImpl);
    }
}

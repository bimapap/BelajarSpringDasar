package bimapap.spring.core;

import bimapap.spring.core.client.PaymentGatewayClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

public class FactoryTest {
    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigReactiveWebApplicationContext(FactoryConfiguration.class);
        context.registerShutdownHook();
    }

    @Test
    void testFactory() {
        PaymentGatewayClient paymentGatewayClient = context.getBean(PaymentGatewayClient.class);

        Assertions.assertNotNull(paymentGatewayClient);
        Assertions.assertEquals("https://example.com",paymentGatewayClient.getEndpoint());
        Assertions.assertEquals("private",paymentGatewayClient.getPrivateKey());
        Assertions.assertEquals("public",paymentGatewayClient.getPublicKey());

    }
}

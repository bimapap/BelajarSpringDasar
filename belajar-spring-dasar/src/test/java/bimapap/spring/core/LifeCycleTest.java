package bimapap.spring.core;

import bimapap.spring.core.data.Connection;
import bimapap.spring.core.data.Server;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleTest {

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp(){
        context = new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);
        context.registerShutdownHook();
    }

//    @AfterEach
//    void tearDown() {
//        context.close();
//    }

    @Test
    void testConnection(){
        Connection conn = context.getBean(Connection.class);
    }

    @Test
    void testServer(){
        context.getBean(Server.class);
    }
}

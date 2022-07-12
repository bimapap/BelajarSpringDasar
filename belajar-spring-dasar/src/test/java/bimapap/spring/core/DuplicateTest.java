package bimapap.spring.core;

import bimapap.spring.core.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DuplicateTest {

    @Test
    void testDuplicate(){
        ApplicationContext context = new AnnotationConfigApplicationContext(DuplicateConfiguration.class);
        Foo foo1 = context.getBean("fooFirst",Foo.class);
        Foo foo2 = context.getBean("fooSecond",Foo.class);
        Assertions.assertNotSame(foo1,foo2);
    }
}

package bimapap.spring.core;

import bimapap.spring.core.data.Bar;
import bimapap.spring.core.data.Foo;
import bimapap.spring.core.data.FooBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependencyInjectionTest {

    private ApplicationContext appContext;

    @BeforeEach
    void setUp(){
        appContext = new AnnotationConfigApplicationContext(DependencyInjectionConfiguration.class);
    }

    @Test
    void testDI(){
        Foo foo = appContext.getBean("fooSecond",Foo.class);
        Bar bar = appContext.getBean(Bar.class);
        FooBar fooBar = appContext.getBean(FooBar.class);

        Assertions.assertSame(foo,fooBar.getFoo());
        Assertions.assertSame(bar, fooBar.getBar());
    }

    @Test
    void testNoDI(){
        var foo = new Foo();
        var bar = new Bar();

        var fooBar = new FooBar(foo,bar);

        Assertions.assertSame(foo,fooBar.getFoo());
        Assertions.assertSame(bar, fooBar.getBar());
    }
}

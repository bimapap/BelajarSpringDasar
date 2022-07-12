package bimapap.spring.core;

import bimapap.spring.core.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Slf4j
@Configuration
public class DuplicateConfiguration {

    @Primary
    @Bean(value = "fooFirst")
    public Foo foo1(){
        Foo foo = new Foo();
        log.info("Create new foo");
        return foo;
    }

    @Bean(value = "fooSecond")
    public Foo foo2(){
        Foo foo = new Foo();
        log.info("Create new foo");
        return foo;
    }
}

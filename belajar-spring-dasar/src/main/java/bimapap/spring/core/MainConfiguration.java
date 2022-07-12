package bimapap.spring.core;

import bimapap.spring.core.configuration.BarConfiguration;
import bimapap.spring.core.configuration.FooConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {
        FooConfiguration.class,
        BarConfiguration.class
})
public class MainConfiguration {

}

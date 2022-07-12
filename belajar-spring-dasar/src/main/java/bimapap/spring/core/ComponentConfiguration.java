package bimapap.spring.core;

import bimapap.spring.core.data.MultiFoo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {
        "bimapap.spring.core.service",
        "bimapap.spring.core.repository",
        "bimapap.spring.core.configuration"
})
@Import(MultiFoo.class)
public class ComponentConfiguration {
}

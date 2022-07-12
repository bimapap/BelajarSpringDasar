package bimapap.spring.core;

import bimapap.spring.core.data.MultiFoo;
import bimapap.spring.core.repository.CategoryRepository;
import bimapap.spring.core.repository.CustomerRepository;
import bimapap.spring.core.repository.ProductRepository;
import bimapap.spring.core.service.CategoryService;
import bimapap.spring.core.service.CustomerService;
import bimapap.spring.core.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

public class ComponentTest {

//    private ConfigurableApplicationContext context;
//
//    @BeforeEach
//    void setUp() {
//        context = new AnnotationConfigReactiveWebApplicationContext(ComponentConfiguration.class);
//        context.registerShutdownHook();
//    }
//
//    @Test
//    void testService() {
//        ProductService productService1 = context.getBean(ProductService.class);
//        ProductService productService2 = context.getBean("productService",ProductService.class);
//        Assertions.assertSame(productService1,productService2);
//    }
//
//    @Test
//    void testConstructorDependencyInjection() {
//        ProductService productService = context.getBean(ProductService.class);
//        ProductRepository productRepository = context.getBean(ProductRepository.class);
//
//        Assertions.assertSame(productRepository,productService.getProductRepository());
//    }
//
//    @Test
//    void testSetterDependencyInjection() {
//       CategoryService categoryService = context.getBean(CategoryService.class);
//       CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);
//
//       Assertions.assertSame(categoryRepository,categoryService.getCategoryRepository());
//
//    }
//
//    @Test
//    void testFieldDependencyInjection() {
//
//        CustomerService customerService = context.getBean(CustomerService.class);
//        CustomerRepository normalCustomerRepository = context.getBean("normalCustomerRepository",CustomerRepository.class);
//        CustomerRepository premiumCustomerRepository = context.getBean("premiumCustomerRepository",CustomerRepository.class);
//
//        Assertions.assertSame(normalCustomerRepository,customerService.getNormalCustomerRepository());
//        Assertions.assertSame(premiumCustomerRepository,customerService.getPremiumCustomerRepository());
//    }
//
//    @Test
//    void testObjectProvider() {
//        MultiFoo multiFoo = context.getBean(MultiFoo.class);
//        Assertions.assertEquals(3,multiFoo.getFoos().size());
//    }
}

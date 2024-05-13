package ecommerce;

import ecommerce.sales.SalesFacade;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ecommerce.catalog.ArrayListProductStorage;
import ecommerce.catalog.ProductCatalog;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");


        SpringApplication.run(App.class, args);
    }

    @Bean
    ProductCatalog createMyProductCatalog() {
        ProductCatalog productCatalog = new ProductCatalog(new ArrayListProductStorage());
        productCatalog.addProduct("set 1", "Decent");
        productCatalog.addProduct("set 2", "Nice");
        productCatalog.addProduct("set 3", "Nice one");

        return productCatalog;
    }
    @Bean
    SalesFacade createMySalesFacade() {
        return new SalesFacade();
    }
}

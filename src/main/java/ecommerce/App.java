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
        productCatalog.addProduct("Lego set 1", "ok");
        productCatalog.addProduct("Cobi set 2", "Nice");

        return productCatalog;
    }
    @Bean
    SalesFacade createMySalesFacade() {
        return new SalesFacade();
    }
}

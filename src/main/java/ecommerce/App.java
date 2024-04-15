package ecommerce;

import ecommerce.catalog.ArrayListProductStorage;
import ecommerce.catalog.HashMapProductStorage;
import ecommerce.catalog.ProductCatalog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class  App {
    public static void main(String[] args){
        System.out.println("Hello world");

        SpringApplication.run(App.class,args);
    }

    @Bean
    ProductCatalog createMyProductCatalog(){
        ProductCatalog productCatalog=new ProductCatalog(new ArrayListProductStorage());
        productCatalog.addProduct("Legoset 1","Nice one");
        productCatalog.addProduct("Legoset2","Nice one too");
        return productCatalog;

    }
}

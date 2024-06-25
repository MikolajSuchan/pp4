package pl.msuchan.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.msuchan.ecommerce.catalog.ArrayListProductStorage;
import pl.msuchan.ecommerce.catalog.ProductCatalog;
import pl.msuchan.ecommerce.sales.SalesFacade;
import pl.msuchan.ecommerce.sales.cart.HashMapCartStorage;
import pl.msuchan.ecommerce.sales.offering.OfferCalculator;
import pl.msuchan.ecommerce.sales.payment.PaymentDetails;
import pl.msuchan.ecommerce.sales.payment.PaymentGateway;
import pl.msuchan.ecommerce.sales.payment.RegisterPaymentRequest;
import pl.msuchan.ecommerce.sales.reservation.ReservationRepository;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        System.out.println("Hello There!");
        SpringApplication.run(App.class, args);
    }

    @Bean
    ProductCatalog createMyProductCatalog() {
        ProductCatalog productCatalog = new ProductCatalog(new ArrayListProductStorage());
        productCatalog.addProduct("set 1", "Decent,Price($):");
        productCatalog.addProduct("set 2", "Nice,Price($):");
        productCatalog.addProduct("set 3", "Nice one,Price($):");

        return productCatalog;
    }
    @Bean
    SalesFacade createSales() {
        return new SalesFacade(
                new HashMapCartStorage(),
                new OfferCalculator(),
                new PaymentGateway() {
                    @Override
                    public PaymentDetails registerPayment(RegisterPaymentRequest registerPaymentRequest) {
                        return null;
                    }
                },
                new ReservationRepository()
        );
    }
}

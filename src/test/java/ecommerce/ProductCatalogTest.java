package ecommerce;

import ecommerce.catalog.Product;
import ecommerce.catalog.ProductCatalog;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ProductCatalogTest {

    @Test
    void itAllowsListingProducts(){
        ProductCatalog catalog= thereIsProductCatalog();

        List<Product> products= catalog.allProducts();

        assert products.isEmpty();
    }

    @Test
    void itAllowsToAddProducts(){
        ProductCatalog catalog= thereIsProductCatalog();

        catalog.addProduct("Legoset 8083","Nice one");

        List<Product> allProducts= catalog.allProducts();

        assertThat(allProducts).hasSize(1);


    }

    @Test
    void itLoadsSingleProductById(){
        ProductCatalog catalog= thereIsProductCatalog();

        String id =catalog.addProduct("Legoset 8083","Nice one");

        Product loaded=catalog.getProductBy(id);

        assertThat(loaded.getId().equals(id));

     }

    @Test
    void itAllowsToChangePrice(){
        ProductCatalog catalog= thereIsProductCatalog();

        String id =catalog.addProduct("Legoset 8083","Nice one");

        catalog.changePrice(id, BigDecimal.valueOf(10.10));
        Product loaded=catalog.getProductBy(id);
        assertThat(loaded.getPrice()).isEqualTo(BigDecimal.valueOf(10.10));
    }
    private ProductCatalog thereIsProductCatalog() {
        return new ProductCatalog();
    }
}

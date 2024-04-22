package ecommerce.playground;

import ecommerce.catalog.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class JdbcPlaygroundTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void itSetupDatabase(){
        var dropTableIfExists="DROP TABLE IF EXISTS `product_catalog__products` IF EXISTS   ";
        jdbcTemplate.execute(dropTableIfExists);

        var createTableSql = "CREATE TABLE `product_catalog__products`("+"`id` varchar(255) NOT NULL,"+"`name` varchar(255) NOT NULL,"+"`price` DECIMAL(12,2),"+"PRIMARY KEY (id)"+");";
        jdbcTemplate.execute(createTableSql);
    }

    @Test
    void selectMyNameViaDB() {
        var name = jdbcTemplate.queryForObject("SELECT 'Mikołaj Suchan' AS hello_column", String.class);
    }
    @Test
    void selectDateNow() {
        var currentDate = jdbcTemplate.queryForObject("select now() my_date", String.class);
        assert currentDate.contains("2024");
    }

    @Test
    void itCreatesTable(){
        var dropTableIfExists="DROP TABLE IF EXISTS `product_catalog__products` IF EXISTS   ";
        jdbcTemplate.execute(dropTableIfExists);

        var createTableSql = "CREATE TABLE `product_catalog__products`("+"`id` varchar(255) NOT NULL,"+"`name` varchar(255) NOT NULL,"+"`price` DECIMAL(12,2),"+"PRIMARY KEY (id)"+");";

        jdbcTemplate.execute(createTableSql);
    }

    @Test
    void itCountsproductsWhenNoproducts(){
        var countSql ="select count(*) from `product_catalog__products`";
        int productsCount = jdbcTemplate.queryForObject(countSql, Integer.class);

        assertThat(productsCount).isEqualTo(0);
    }

    @Test
    void itAllowsToInsertElements(){
        var insertsql="INSERT INTO `product_catalog__products` (id,name,price)"+"VALUES"+"('product_1','my_product 1',20.25),"+"('product_2','my_product 2',13.30)";
        jdbcTemplate.execute(insertsql);
        var countSql="select count(*) from `product_catalog__products`";
        int productCount = jdbcTemplate.queryForObject(countSql, Integer.class);

        assertThat(productCount).isEqualTo(2);
    }

    @Test
    void itAllowsToInsertDynamicElements(){
        var insertsql="INSERT INTO `product_catalog__products`(id,name,price)"+"VALUES"+"(?,?,?)";
        var product = new Product(UUID.randomUUID(),"my_product","Nice one");

        product.changePrice(BigDecimal.TEN);

        jdbcTemplate.update(insertsql,product.getId(),product.getName(),product.getPrice());

        var countSql="select count(*) from `product_catalog__products`";
        int productCount = jdbcTemplate.queryForObject(countSql, Integer.class);

        assertThat(productCount).isEqualTo(1);
    }

    @Test
    void selectForProdutcs(){
        var insertsql = "INSERT INTO `product_catalog__products` (id, name, price) VALUES ('product_1', 'my_product 1', 20.25), ('product_2', 'my_product 2', 13.30);";
        jdbcTemplate.execute(insertsql);
        var selectSql="select * from `product_catalog__products` where id = ?";
        var myProduct = jdbcTemplate.queryForObject(
                selectSql,
                new Object[]{"product_1"},
                (rs,i)->{
                    var myResult=new Product(UUID.randomUUID(),
                            rs.getString("name"),
                            rs.getString("name")
                    );
                    myResult.changePrice(BigDecimal.valueOf(rs.getDouble("price")));

                    return myResult;
                }
        );
        assertThat(myProduct.getName()).isEqualTo("my_product 1");
    }
}

package ecommerce.playground;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
public class JdbcPlaygroundTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

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
        var createTableSql = "CREATE TABLE `product_catalog__products`("+"`id` varchar(255) NOT NULL,"+"`name` varchar(255) NOT NULL,"+"`price` DECIMAL(12,2),"+"PRIMARY KEY (id)"+");";

        jdbcTemplate.execute(createTableSql);
    }


}

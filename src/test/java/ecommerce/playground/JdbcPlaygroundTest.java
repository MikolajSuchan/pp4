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
    void selectMyNameViaDB(){

        var name=jdbcTemplate.queryForObject(
                "select'Mikołaj Suchan'hello_column",
                String.class
        );

    }


}

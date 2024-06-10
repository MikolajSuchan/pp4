package pl.msuchan.ecommerce.sales.cart;

import java.util.Map;
import java.util.Optional;

public class HashMapCartStorage {
    Map<String,Cart> carts;

    public HashMapCartStorage(Map<String, Cart> carts) {
        this.carts = carts;
    }

    public Optional<Cart> findByCustomer(String customerId) {
        return Optional.ofNullable(carts.get(customerId));
    }

    public void save(String customerId, Cart cart) {
        carts.put(customerId, cart);
    }
}

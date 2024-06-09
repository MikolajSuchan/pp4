package pl.msuchan.ecommerce.sales;

import pl.msuchan.ecommerce.sales.cart.Cart;
import pl.msuchan.ecommerce.sales.cart.HashMapCartStorage;
import pl.msuchan.ecommerce.sales.offering.AcceptOfferRequest;
import pl.msuchan.ecommerce.sales.offering.Offer;
import pl.msuchan.ecommerce.sales.reservation.ReservationDetail;

public class SalesFacade {
    private HashMapCartStorage cartStorage;

    public Offer getCurrentOffer(String customerId) {
        return new Offer();
    }

    public void addToCart(String customerId, String productId) {

    }

    private Cart loadCartForCustomer(String customerId) {
        return null;//cartStorage.fundByCutomer(customerId)
                //.orElse(Cart.empty());
    }

    public ReservationDetail acceptOffer(String customerId, AcceptOfferRequest acceptOfferRequest) {
        return new ReservationDetail();
    }

}

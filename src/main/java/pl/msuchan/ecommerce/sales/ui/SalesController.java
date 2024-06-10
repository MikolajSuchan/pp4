package pl.msuchan.ecommerce.sales.ui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.msuchan.ecommerce.sales.SalesFacade;
import pl.msuchan.ecommerce.sales.offering.AcceptOfferRequest;
import pl.msuchan.ecommerce.sales.offering.Offer;
import pl.msuchan.ecommerce.sales.reservation.ReservationDetail;

@RestController
public class SalesController {
    SalesFacade salesFacade;

    public SalesController(SalesFacade salesFacade) {
        this.salesFacade = salesFacade;
    }

    @PostMapping("/api/add-to-cart/{productId}")
    void addToCart(@PathVariable String productId) {
        String customerId = getCurrentCustomerId();
        salesFacade.addToCart(customerId, productId);
    }

    @GetMapping("/api/current-offer")
    Offer getCurrentOffer(){
        String customerId = getCurrentCustomerId();
        return salesFacade.getCurrentOffer(customerId);
    }

    @PostMapping("/api/accept-offer")
    ReservationDetail acceptOffer(AcceptOfferRequest acceptOfferRequest){
        String customerId = getCurrentCustomerId();
        ReservationDetail reservationDetails =
                salesFacade.acceptOffer(customerId, acceptOfferRequest);
        return reservationDetails;
    }

    private String getCurrentCustomerId() {
        return "Mikołaj";
    }
}

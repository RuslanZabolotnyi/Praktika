package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PageTitle {
    PRODUCTS("Products"),
    CART("Your Cart"),
    CHECKOUT_YI("Checkout: Your Information"),
    CHECKOUT_OV("Checkout: Overview"),
    CHECKOUT_COMP("Checkout: Complete!");

    private final String displayName;
}

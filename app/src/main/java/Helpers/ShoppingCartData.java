package Helpers;

import java.util.ArrayList;

import Model.Product;

/**
 * Created by Cruze on 2/7/2017.
 */

public class ShoppingCartData {
    private static ArrayList<Product> cartList = new ArrayList<>();

    public static ArrayList<Product> getCartList() {
        return cartList;
    }

    public static void setCartList(Product cartList) {
        ShoppingCartData.cartList.add(cartList);
    }
}

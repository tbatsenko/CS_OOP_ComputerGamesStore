package store;

import java.util.ArrayList;

public class CartDecorator extends Cart{
    private Cart cartToDecorate;

    CartDecorator(Cart cart){
        cartToDecorate = cart;
    }

    @Override
    public void setPs(PaymentStrategy ps) {
        cartToDecorate.setPs(ps);
    }

    @Override
    public void setDs(DeliveryStrategy ds) {
        cartToDecorate.setDs(ds);
    }

    @Override
    public double computeTotalPrice(){
        return super.computeTotalPrice();
    }

    @Override
    public boolean ship(){
        if (cartToDecorate.ps.pay(computeTotalPrice())) {
            cartToDecorate.ds.deliver(order);
            cartToDecorate.setDelivered();
            return true;
        }
        return false;


    }
}

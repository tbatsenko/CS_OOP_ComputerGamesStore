package store;

public class DiscountCart extends Cart{
    private Cart cart;
    public DiscountCart(Cart cart){
        super(cart.order);
        this.cart = cart;

    }

    public void setPs(PaymentStrategy ps) {
        cart.setPs(ps);
    }

    public void setDs(DeliveryStrategy ds) {
        cart.setDs(ds);
    }

    public double computeTotalPrice(){
        return 12.13;
    }
//    public void ship(){
//        if (cart.ps.pay(computeTotalPrice())) {
//            cart.ds.deliver(order);
//        }
//
//    }
//
//    void deliver(ArrayList<ComputerGame> games);
}

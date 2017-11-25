package store;

public class DiscountDecorator extends CartDecorator{
    public DiscountDecorator(Cart cart){
        super(cart);
    }

    @Override
    public double computeTotalPrice() {
        return super.computeTotalPrice() * 0.9;
    }
}

package store;

import java.util.ArrayList;

public class Cart {
    private PaymentStrategy ps;
    private DeliveryStrategy ds;
    ArrayList<ComputerGame> order;

    Cart(ArrayList<ComputerGame> order) {
        this.order = order;
    }

    public void setPs(PaymentStrategy ps) {
        this.ps = ps;
    }

    public void setDs(DeliveryStrategy ds) {
        this.ds = ds;
    }

    public double computeTotalPrice(){
        return 12.13;
    }
    public void ship(){
        if (ps.pay(computeTotalPrice())) {
            ds.deliver(order);
        }

    }
}

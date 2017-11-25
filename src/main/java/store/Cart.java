package store;

import java.util.ArrayList;

public class Cart {
    PaymentStrategy ps;
    DeliveryStrategy ds;
    ArrayList<ComputerGame> order;
    private boolean isDelivered = false;

    Cart() {
        order = new ArrayList<>();
    }

    ArrayList<ComputerGame> getOrder() {
        return order;
    }


    boolean isDelivered() {
        return isDelivered;
    }

    void setDelivered() {
        isDelivered = true;
    }

    public void setPs(PaymentStrategy ps) {
        this.ps = ps;
    }

    public void setDs(DeliveryStrategy ds) {
        this.ds = ds;
    }

    boolean addGame(ComputerGame game){
        if (game == null || game.getParams().getTitle() == null) return false;
        order.add(game);
        return true;
    }

    public double computeTotalPrice(){
        float totalPrice = 0;
        for (ComputerGame game: order) {
            totalPrice += game.getParams().getPrice();
        }
        return totalPrice;
    }
    public boolean ship(){
        if (ps.pay(computeTotalPrice())) {
            ds.deliver(order);
            this.setDelivered();
            return true;
        }
        return false;

    }
}

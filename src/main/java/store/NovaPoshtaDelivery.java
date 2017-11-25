package store;

import java.util.ArrayList;

public class NovaPoshtaDelivery implements DeliveryStrategy {
    @Override
    public boolean deliver(ArrayList<ComputerGame> order) {
        System.out.println("Successfully devivered by NovaPoshta");
        return true;
    }
}

package store;

import java.util.ArrayList;

public interface DeliveryStrategy {
    boolean deliver(ArrayList<ComputerGame> order);
}

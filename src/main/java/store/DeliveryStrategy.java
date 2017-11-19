package store;

import java.util.ArrayList;

public interface DeliveryStrategy {
    void deliver(ArrayList<ComputerGame> order);
}

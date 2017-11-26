package store;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ObserversTest {
    private Cart testObserverableCart;
    {
        testObserverableCart = new Cart();
        testObserverableCart.setPs(new PayPalStrategy());
        testObserverableCart.setDs(new NovaPoshtaDelivery());
    }

    @Before
    public void setup(){
        System.out.println("Running Cart Test...");
    }

    @Test
    public void addGameWithNullParams() {
        assertFalse(testObserverableCart.addObserver(null));
    }

    @Test
    public void addMeaningfullObserver() {
        // covers Customer Tests
        Customer customer1 = new Customer("Jill");
        assert(testObserverableCart.addObserver(customer1));
    }

    @Test
    public void removeNullObserver() {
        assertFalse(testObserverableCart.removeObserver(null));
    }

    @Test
    public void removeObserver() {
        Customer customer1 = new Customer("Jill");
        Customer customer2 = new Customer("Jhon");
        testObserverableCart.addObserver(customer1);
        testObserverableCart.addObserver(customer2);
        assert(testObserverableCart.removeObserver(customer1));
    }

    @Test
    public void notifyObservers() {
        Customer customer1 = new Customer("Jill");
        Seller seller = new Seller("Jhon");
        testObserverableCart.addObserver(customer1);
        testObserverableCart.addObserver(seller);
        testObserverableCart.notifyAllObservers();
    }

}

package store;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CartTest {
    private Cart testCart;
    {
        testCart = new Cart();
        testCart.setPs(new PayPalStrategy());
        testCart.setDs(new NovaPoshtaDelivery());
    }

    @Before
    public void setup(){
        System.out.println("Running Cart Test...");
    }

    @Test
    public void addGameWithNullParams() {
        assertFalse(testCart.addGame(null));
    }

    @Test
    public void addGameWithNullTitle() {
        // covers Test ComputerGameParams automatically
        ComputerGameParams gameParams = new ComputerGameParams(null, null, null, null, 0, 0);
        assertFalse(testCart.addGame(new ComputerGame(gameParams)));
    }

    @Test
    public void addGameWithMeaningfullParams() {
        // covers Test ComputerGameParams automatically
        ComputerGameParams gameParams = new ComputerGameParams(null, null, "My Super Hero", null, 12, 12);
        assert(testCart.addGame(new ComputerGame(gameParams)));
    }

    @Test
    public void checkIsDeliveredWithoutShipping() {
        // covers Test ComputerGameParams automatically
        assertFalse(testCart.isDelivered());
    }

    @Test
    public void checkIsDeliveredAfrerShipping() {
        // covers Test ComputerGameParams automatically + PayPalStrategy + NovaPoshtaDelivery
        ComputerGameParams gameParams = new ComputerGameParams(null, null, "My Super Hero", null, 12, 12);
        testCart.addGame(new ComputerGame(gameParams));
        testCart.ship();
        assertTrue(testCart.isDelivered());
    }

    @Test
    public void getOrderResetPsAndDeviver() {
        // covers Test ComputerGameParams automatically  + CashStrategy
        ComputerGameParams game1Params = new ComputerGameParams(null, null, "My Super Hero", null, 12, 12);
        ComputerGameParams game2Params = new ComputerGameParams(null, null, "My Super Hero 2", null, 23, 18);

        testCart.addGame(new ComputerGame(game1Params));
        testCart.addGame(new ComputerGame(game2Params));

        System.out.println(testCart.getOrder());

        testCart.setPs(new CashStrategy());
        testCart.ship();
        assertTrue(testCart.isDelivered());
    }

    @Test
    public void shipDiscountedCart() {
        // covers CartDecorators  Tests
        ComputerGameParams game1Params = new ComputerGameParams(null, null, "My Super Hero", null, 12, 12);
        ComputerGameParams game2Params = new ComputerGameParams(null, null, "My Super Hero 2", null, 23, 18);

        testCart.addGame(new ComputerGame(game1Params));
        testCart.addGame(new ComputerGame(game2Params));

        System.out.println("Sale today! Let's apply discounts");

        assertTrue(new DiscountDecorator(testCart).ship());
    }
}

package store;

public class PayPalStrategy implements PaymentStrategy{
    @Override
    public boolean pay(double price){
        System.out.format("Successfully payed %.2f UAH by PayPal \n",  price);
        return true;
    }
}

package store;

public class CashStrategy implements PaymentStrategy {
    @Override
    public boolean pay(double price){
        System.out.format("Successfully payed %.2f UAH by cash", price);
        return true;
    }
}

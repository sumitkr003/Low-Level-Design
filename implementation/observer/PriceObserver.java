package implementation.observer;

//Concrete observer
public class PriceObserver implements OrderObserver {

    @Override
    public void updated(Order order) {
        double total = order.getItemCost();
        System.out.println("Updating discount based on price change");
        if(total >= 500) {
            order.setDiscount(20);
        } else if(total >= 200) {
            // give discount
            order.setDiscount(10);
        }

    }
}

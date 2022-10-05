package implementation.observer;

public class Client {

    public static void main(String[] args) {
        Order order = new Order("orderId");
        PriceObserver priceObserver = new PriceObserver();
        QuantityObserver quantityObserver = new QuantityObserver();
        order.subscribe(priceObserver);
        order.subscribe(quantityObserver);

        order.addItem(50);
        System.out.println(order);
        System.out.println("++++++++++++");

        order.addItem(200);
        System.out.println(order);
        System.out.println("++++++++++++");

        order.addItem(500);
        System.out.println(order);
        System.out.println("++++++++++++");

    }
}

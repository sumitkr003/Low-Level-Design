package implementation.strategy;


import java.util.LinkedList;

//Context 
public class PrintService {

    private OrderPrinter printer;
    public PrintService(OrderPrinter printer) {
        this.printer = printer;
    }

    public void printOrders(LinkedList<Order> orders) {
        printer.print(orders);
    }

    public void setPrinter(OrderPrinter printer){
        this.printer = printer;
    }
}

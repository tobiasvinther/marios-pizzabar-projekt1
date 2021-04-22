package Orders;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import Statistics.Statistics;

public class OrderList {

    private static int waitTime = 0; //wait time in minutes based on number of pizzas in the listOfOrders
    private final int COOK_TIME = 10; //minutes to cook one pizza
    private static ArrayList<Order> listOfOrders = new ArrayList<>(); //static because we only want one to exist

    //prints all the orders in the order list
    public void printListOfOrders() {
        calculateWaitTime();
        calculateTimeToPickup();
        for (Order order : listOfOrders) {
            order.printOrder();
        }
    }

    //add order to list of orders (and also to statistics)
    public void addToListOfOrders(Order thisOrder) {
        listOfOrders.add(thisOrder);
        Statistics.allOrders.add(thisOrder);
    }

    //remove order from list of orders (by ID)
    public void removeFromListOfOrders(int orderIDToRemove) {

        Order tempOrder = new Order("temp");

        for(Order order : listOfOrders) {
            if(order.getOrderID() == orderIDToRemove) {
                tempOrder = order; //if order with this orderID is on the orderList, set tempOrder to this order
            }
        }
        listOfOrders.remove(tempOrder); //delete tempOrder which is now the order with the orderID from the parameter
        System.out.println("Removed order #" + orderIDToRemove);

    }

    //call to calculate waiting time (in minutes) based on how many pizzas are currently waiting to be made
    public void calculateWaitTime() {
        //go through list of orders...
        for (Order order : listOfOrders) {
            //and then, in each order, check how large the getPizzaLineItemList() (which indicates the number of pizzas
            //in that order) and then add COOK_TIME to waitTime for each pizza
            for (int i = 0; i < order.getPizzasInThisOrder().size(); i++) {
                waitTime = waitTime + COOK_TIME;
            }
        }
    }

    //call this to calculate when a pickup will be ready for pickup, based on the current waiting time
    public LocalTime calculateTimeToPickup() {
        LocalTime time = LocalTime.now();
        time = time.plusMinutes(waitTime).truncatedTo(ChronoUnit.MINUTES);
        //System.out.println(time.truncatedTo(ChronoUnit.MINUTES));
        return time;
    }
}

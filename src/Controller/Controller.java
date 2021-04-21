package Controller;

import Orders.Order;
import Orders.OrderList;
import Pizzas.PizzaList;
import Statistics.Statistics;
import java.time.LocalTime;

public class Controller {

    OrderList orderList = new OrderList();
    Statistics statistics = new Statistics();
    PizzaList pizzaList = new PizzaList();

    //prints list of orders
    public void checkOrderList () {
        orderList.printListOfOrders();
    }

    //creates and returns a new order with customer name
    public Order createNewOrder (String nameOfCustomer) {
        Order newOrder = new Order(nameOfCustomer);
        return newOrder;
    }

    //adds a pizza (one or more of the same pizza) to an order
    public void addPizzaToOrder(Order order, int id, int quantity){
        order.addPizzaToOrder(id, quantity);
    }

    //adds comment to an order
    public void addCommentToOrder(Order order, String comment) {
        order.setComment(comment);
    }

    //returns pickuptime for an order and puts it in the list of orders
    public LocalTime getPickupTime(Order order) {
        orderList.calculateWaitTime();
        LocalTime time = orderList.calculateTimeToPickup();
        order.setPickupTime(time);
        orderList.addToListOfOrders(order);
        return order.getPickupTime();
    }

    //remove with name. Not used
    public void removeFromListOfOrders(String nameOfCustomer) {
        orderList.removeFromListOfOrders(nameOfCustomer);
    }

    //remove with order ID
    public void removeFromListOfOrders(int orderIDToDelete) {
        orderList.removeFromListOfOrders(orderIDToDelete);
    }

    //prints statistics of sold pizzas
    public void getStatistics() {
        statistics.amountSoldOfEachPizza();
    }

    //prints list of available pizzas, with id, name and price
    public void printPizzaList() {
        pizzaList.printPizzaList();
    }

}

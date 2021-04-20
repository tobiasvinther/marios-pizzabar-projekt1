package Orders;
import Pizzas.*;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Order {

    //Attributes
    private String nameOfCustomer;
    private ArrayList<Pizza> pizzasInThisOrder = new ArrayList<>(); //list of pizzas the order contains
    private int totalPizzas;
    private LocalTime pickupTime;
    private int totalPrice;
    private String comment = "Ingen kommentarer";
    private int orderID;
    private static int orderCounter = 1;

    //constructor with just name as input
    public Order(String nameOfCustomer) {
        this.nameOfCustomer = nameOfCustomer;
        this.orderID = orderCounter;
        orderCounter++;
    }

    //Constructor. Never used though
    public Order(String nameOfCustomer, int totalPizzas, LocalTime pickupTime) {
        this.nameOfCustomer = nameOfCustomer;
        this.totalPizzas = totalPizzas;
        this.pickupTime = pickupTime;
    }

    public ArrayList<Pizza> getPizzasInThisOrder() {
        return this.pizzasInThisOrder;
    }

    public LocalTime getPickupTime() {
        return this.pickupTime;
    }

    public int getOrderID() {
        return this.orderID;
    }

    public void setPickupTime(LocalTime pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getNameOfCustomer() {
        return this.nameOfCustomer;
    }

    public void setNameOfCustomer(String name) {
        this.nameOfCustomer = name;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    //get id and quantity from user input and use that to create copies of the relevant pizzas and add them to
    //pizzaLineItemList, which is this order's list of pizzas
    public void addPizzaToOrder(int id, int quantity) {
        //get name and price from pizzaList and create a copy of that pizza to use in this order
        String name = PizzaList.pizzaList.get(id-1).getName(); //subtract 1 to get the correct index
        int price = PizzaList.pizzaList.get(id-1).getPrice();

        Pizza thisPizza = new Pizza(id, name, price);

        //create number of this pizza equal to quantity
        for (int i=1; i<= quantity; i++) {
            pizzasInThisOrder.add(thisPizza);
            totalPizzas++;
            totalPrice = totalPrice + thisPizza.getPrice();
        }
    }

    //call this to print an order
    public void printOrder() {
        System.out.println("-------------");
        System.out.println("Ordrenummer: " + orderID);
        System.out.println("Kundenavn: " + nameOfCustomer);
        printPizzasInThisOrder();
        System.out.println(comment);
        System.out.println("Afhentning: " + pickupTime);
        System.out.println("Pris: " + totalPrice + " kr.");
    }

    //prints id and name of all pizzas in pizzaLineItemList (which is a list of the pizzas in this order)
    public void printPizzasInThisOrder() {
        for(Pizza pizza : pizzasInThisOrder) {
            System.out.println(pizza.getID() + " " + pizza.getName());
        }
    }
}

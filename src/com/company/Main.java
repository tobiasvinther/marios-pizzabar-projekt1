package com.company;
import Menu.Menu;
import Orders.*;
import Pizzas.PizzaList;

import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //initialize the pizzaList (the menu containing all available pizzas)
        PizzaList.createPizzaList();

        //generate some orders to put in our order list
        generateRandomOrders(5);

        //start the main menu
        Menu menu = new Menu();
        menu.mainMenu();

    }

    //generate x random orders and put them in the orderList
    public static void generateRandomOrders(int numOfOrdersToGenerate) {
        String[] nameList = {"Frodo", "Merry", "Pippin", "Sam", "Aragorn", "Eowyn", "Arwen", "Gandalf", "Boromir", "Gimli", "Legolas"};
        String[] commentList = {"Ingen kommentarer", "Ingen ost", "Ekstra bacon", "Plus champignon"};
        OrderList testOrderList = new OrderList();
        Random randomNum = new Random();

        for(int i=0; i<numOfOrdersToGenerate; i++) {
            int randomCommentIndex = randomNum.nextInt(commentList.length);
            int randomNameIndex = randomNum.nextInt(nameList.length);
            int randomTotalPizzas = randomNum.nextInt(4)+1;

            Order generatedOrder = new Order(nameList[randomNameIndex]);

            for(int k=0; k<randomTotalPizzas; k++) {
                int randomID = randomNum.nextInt(13)+1;
                int randomQuantity = randomNum.nextInt(1)+1;
                generatedOrder.addPizzaToOrder(randomID,randomQuantity);
            }
            generatedOrder.setComment(commentList[randomCommentIndex]);
            testOrderList.calculateWaitTime();
            //int curWaitTime = testOrderList.getWaitTime();
            LocalTime time = testOrderList.calculateTimeToPickup();
            generatedOrder.setPickupTime(time);
            testOrderList.addToListOfOrders(generatedOrder);
        }
    }
}

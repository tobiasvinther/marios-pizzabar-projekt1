package Menu;
import Controller.Controller;
import Orders.Order;
import Orders.OrderList;

import java.time.LocalTime;
import java.util.Scanner;

public class Menu {

    //Initializing Scanner, OrderList, LoginMenu and Controller objects.
    Scanner scanner = new Scanner(System.in);
    OrderList orderList = new OrderList();
    LoginMenu loginMenu = new LoginMenu();
    Controller controller = new Controller();

    //A getUserInput method which is used in the switch statements, so the user can be prompt.
    public int getUserInput() {
        int userInput = scanner.nextInt();
        return userInput;
    }

    //mainMenu method so the user can integrate with these options
    public void mainMenu() {
        System.out.println();
        System.out.println("----- Welcome! -----");
        System.out.println(">> Press 1 to create a order <<");
        System.out.println(">> Press 2 to check the orderlist <<");
        System.out.println(">> Press 3 to login <<");
        System.out.println(">> Press 4 to see the pizzalist <<");
        System.out.println(">> Press 5 to complete order <<");
        System.out.println(">> Press 6 to exit <<");

            //Switch statements
            switch (getUserInput()) {
                case 1:
                    System.out.println("You chose to create a order: ");
                    System.out.println();
                    //Calls the newOrder method so the user can create a new order
                    newOrder();
                    //When done the user will be sent back to the mainMenu.
                    mainMenu();
                    break;

                case 2:
                    System.out.println("You chose to check the orderlist: ");
                    System.out.println();
                    //Calls the checkOrderList through the controller
                    controller.checkOrderList();
                    //Sent back to the mainMenu
                    mainMenu();
                    break;

                case 3:
                    System.out.println();
                    System.out.println("You chose to login");
                    //Created a password forehand
                    int password = 45678;
                    System.out.println("Enter password: ");
                    int enterPassword = scanner.nextInt();
                    //If the password is true, a new menu will be shown where the user can see the statistics
                    if (enterPassword == 45678) {
                        loginMenu.advancedLoginMenu();
                        mainMenu();
                    }
                    //If password is false, the user will be sent back to mainMenu with an error, wrong password message
                    else if (enterPassword != 45678) {
                        System.out.println("Error, wrong password!\n" + "You will be sent back to the menu");
                        System.out.println();
                        mainMenu(); //Try again
                    }
                    break;

                case 4:
                    //Prints the pizzaList which is called through the controller
                    controller.printPizzaList();
                    mainMenu();
                    break;

                case 5:
                    //Delete order case, the orderList is called through the controller
                    controller.checkOrderList();
                    System.out.println("Enter order ID of the order to delete");
                    //The user is asked about with order they want to delete
                    int orderNumberToDelete = scanner.nextInt();
                    //The controller calls the removeFromListOfOrders method, and removes the order that the user entered
                    controller.removeFromListOfOrders(orderNumberToDelete);
                    //Sent back to mainMenu
                    mainMenu();
                    break;

                case 6:
                    break;
            }
        }

        //newOrder method
        public void newOrder() {
        Scanner userInput = new Scanner(System.in);

            //PizzaList is printed in the beginning of every new order
            controller.printPizzaList();
            System.out.println("Enter the customers name: ");
            String name = userInput.nextLine();
            //New order created, and the prompted name is added to the new order
            Order newOrder = controller.createNewOrder(name);
            //The new order is added to the newOrderAddPizza method
            newOrderAddPizza(newOrder);
            //Comments is added to the new order
            System.out.println("Any comments to the order? etc +/-: ");
            String comment = userInput.nextLine();
            controller.addCommentToOrder(newOrder, comment);
            //pick up time is added to the new order and printed on the screen
            System.out.print("This is the pick up time: ");
            LocalTime pickUpTime = controller.getPickupTime(newOrder);
            System.out.println(pickUpTime);

        }

        public void newOrderAddPizza(Order newOrder) {
            Scanner userInput = new Scanner(System.in);

            System.out.println("Enter pizza ID: ");
            int pizzaID = userInput.nextInt();
            System.out.println("How many of this pizza?");
            int quantity = userInput.nextInt();
            //adds pizzas to the newOrder through the controller
            controller.addPizzaToOrder(newOrder, pizzaID, quantity);

            //If there are no more pizzas to add to the order, press 0
            System.out.println("Press 0 if there are no more pizzas to add");
            //If there are more pizzas to add to the order, press 1
            System.out.println("Press 1 to add another pizza");
            //If there are more pizzas to add, the method will call itself so it can be added, if press 0, return;
            if(userInput.nextInt() == 0) {
                return;
            } else newOrderAddPizza(newOrder);

        }

}

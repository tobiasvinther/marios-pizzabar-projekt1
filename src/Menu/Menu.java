package Menu;
import Controller.Controller;
import Orders.Order;
import Orders.OrderList;

import java.time.LocalTime;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    OrderList orderList = new OrderList();
    LoginMenu loginMenu = new LoginMenu();
    Controller controller = new Controller();

    public int getUserInput() {
        int userInput = scanner.nextInt();
        return userInput;
    }

    public void mainMenu() {
        System.out.println();
        System.out.println("----- Welcome! -----");
        System.out.println(">> Press 1 to create a order <<");
        System.out.println(">> Press 2 to check the orderlist <<");
        System.out.println(">> Press 3 to login <<");
        System.out.println(">> Press 4 to see the pizzalist <<");
        System.out.println(">> Press 5 to complete order <<");
        System.out.println(">> Press 6 to exit <<");


            switch (getUserInput()) {
                case 1:
                    System.out.println("You chose to create a order: ");
                    System.out.println();
                    newOrder();
                    //Controller to add the pizza to the arraylist etc.
                    mainMenu();
                    break;

                case 2:
                    System.out.println("You chose to check the orderlist: ");
                    System.out.println();
                    controller.checkOrderList();
                    mainMenu();
                    break;

                case 3:
                    System.out.println();
                    System.out.println("You chose to login");
                    int password = 45678;
                    System.out.println("Enter password: ");
                    int enterPassword = scanner.nextInt();
                    if (enterPassword == 45678) {
                        loginMenu.advancedLoginMenu();
                    }
                    else if (enterPassword != 45678) {
                        System.out.println("Error, wrong password!\n" + "You will be sent back to the menu");
                        System.out.println();
                        mainMenu(); //Try again
                    }
                    break;

                case 4:
                    controller.printPizzaList();
                    break;

                case 5:
                    controller.checkOrderList();
                    System.out.println("Enter order ID of the order to delete");
                    int orderNumberToDelete = scanner.nextInt();
                    controller.removeFromListOfOrders(orderNumberToDelete);
                    mainMenu();
                    break;

                case 6:
                    break;


            }
        }

        public void newOrder() {
        Scanner userInput = new Scanner(System.in);

            controller.printPizzaList();
            System.out.println("Enter the customers name: ");
            String name = userInput.nextLine();
            Order newOrder = controller.createNewOrder(name);
            newOrderAddPizza(newOrder);
            /*
            System.out.println("Enter the pizza ID: ");
            int pizzaID = userInput.nextInt();
            System.out.println("How many pizzas?");
            int quantity = userInput.nextInt();
            controller.addPizzaToOrder(newOrder, pizzaID, quantity);
            //userInput.nextLine();
             */
            System.out.println("Any comments to the order? etc +/-: ");
            String comment = userInput.nextLine();
            controller.addCommentToOrder(newOrder, comment);
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
            controller.addPizzaToOrder(newOrder, pizzaID, quantity);

            System.out.println("Press 0 if there are no more pizzas to add");
            System.out.println("Press 1 to add another pizza");
            if(userInput.nextInt() == 0) {
                return;
            } else newOrderAddPizza(newOrder);


        }

}

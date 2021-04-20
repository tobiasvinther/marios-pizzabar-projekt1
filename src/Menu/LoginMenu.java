package Menu;

import Controller.Controller;
import Orders.Order;
import java.util.Scanner;

public class LoginMenu {

    Scanner loginSc = new Scanner(System.in);
    Controller controller = new Controller();

    public int getLoginInput() {
        int loginInput = loginSc.nextInt();
        return loginInput;
    }

    public void advancedLoginMenu() {

        System.out.println();
        System.out.println("Welcome!");
        System.out.println("Here are your options:\nPress 1 to see the pizza statistics\n");

        switch (getLoginInput()) {
            case 1:
                System.out.println("You chose to see the statistics for the pizzas");
                //Waiting for the statistic class, before i can write the functions
                controller.getStatistics();
                break;


        }
    }
}


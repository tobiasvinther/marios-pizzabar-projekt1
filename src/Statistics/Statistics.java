package Statistics;

import Orders.Order;
import Orders.OrderList;
import Pizzas.Pizza;

import java.util.ArrayList;

public class Statistics {

    OrderList ol = new OrderList();

    public ArrayList<Order> allOrders = ol.getListOfOrders();

    public void amountSoldOfEachPizza() {

        //for (typeonlist variabelname : listname)
        ArrayList<Pizza> a = new ArrayList<>();
        //Each order adds all of the orders pizza
        for (Order o : allOrders) {
            a.addAll(o.getPizzasInThisOrder());
        }

        //Variables of each pizza sum
        int vesuvio = 0;
        int amerikaner = 0;
        int cacciatore = 0;
        int carbona = 0;
        int dennis = 0;
        int bertil = 0;
        int silvia = 0;
        int victoria = 0;
        int toronfo = 0;
        int capricciosa = 0;
        int hawai = 0;
        int leBlissola = 0;
        int venezia = 0;
        int mafia = 0;

        //Input the pizza id's from the list , make a counter and add up.
        for (Pizza p : a) {
            if (p.getID() == 1) {
            vesuvio++;
            }
            else if (p.getID() == 2) {
                amerikaner++;
            }
            else if (p.getID() == 3) {
                cacciatore++;
            }
            else if (p.getID() == 4) {
                carbona++;
            }
            else if (p.getID() == 5) {
                dennis++;
            }
            else if (p.getID() == 6) {
                bertil++;
            }
            else if (p.getID() == 7) {
                silvia++;
            }
            else if (p.getID() == 8) {
                victoria++;
            }
            else if (p.getID() == 9) {
                toronfo++;
            }
            else if (p.getID() == 10) {
                capricciosa++;
            }
            else if (p.getID() == 11) {
                hawai++;
            }
            else if (p.getID() == 12) {
                leBlissola++;
            }
            else if (p.getID() == 13) {
                venezia++;
            }
            else if (p.getID() == 14) {
                mafia++;
            }

        }
        System.out.println("Vesuvio: " + vesuvio +
                "\nAmerikaner: " + amerikaner +
                "\nCacciatore: " + cacciatore +
                "\nCarbona: " + carbona +
                "\nDennis: " + dennis +
                "\nBertil: " + bertil +
                "\nSilvia: " + silvia +
                "\nVictoria: " + victoria +
                "\nToronfo: " + toronfo +
                "\nCapricciosa: " + capricciosa +
                "\nHawai: " + hawai +
                "\nLe Blissola: " + leBlissola +
                "\nVenezia: " + venezia +
                "\nMafia: " + mafia);
    }
}

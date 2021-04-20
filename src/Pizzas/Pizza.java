package Pizzas;

public class Pizza {

    private int id;
    private String name;
    private int price;

    //constructor
    public Pizza(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    //getters
    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {

        //variables and loop to calculate how many dots we need and then add them to a string
        //this is for making the menu look nice so each price lines up with dots from the name to the price, like in the
        //actual paper menu
        String dots = "";
        int dotTarget = 15 - name.length();
        for(int i=0; i<dotTarget; i++) {
            dots = dots + ".";
        }

        if(id<10) {
            return " " + id + ". " + name + dots + price + ",-";
        } else {
            return id + ". " + name + dots + price + ",-";
        }
    }

}

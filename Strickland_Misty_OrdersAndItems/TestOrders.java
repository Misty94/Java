import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        Item item1 = new Item();
        item1.name = "Mocha";
        item1.price = 3.50;

        Item item2 = new Item();
        item2.name = "Latte";
        item2.price = 4.10;

        Item item3 = new Item();
        item3.name = "Drip Coffee";
        item3.price = 2.50;

        Item item4 = new Item();
        item4.name = "Capuccino";
        item4.price = 4.75;
    
        // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        order1.name = "Cindhuri";
        order1.ready = true;

        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);

        Order order2 = new Order();
        order2.name = "Jimmy";
        order2.items.add(item1);
        order2.total += item1.price;
        order2.ready = true;

        System.out.printf("Name: %s\n", order2.name);
        System.out.printf("Total: %s\n", order2.total);
        System.out.printf("Ready: %s\n", order2.ready);

        Order order3 = new Order();
        order3.name = "Noah";
        order3.items.add(item4);
        order3.total += item4.price;

        System.out.printf("Name: %s\n", order3.name);
        System.out.printf("Total: %s\n", order3.total);
        System.out.printf("Ready: %s\n", order3.ready);

        Order order4 = new Order();
        order4.name = "Sam";
        order4.items.add(item2);
        order4.items.add(item2);
        order4.items.add(item2);
        order4.total += (item2.price * 3);

        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("Ready: %s\n", order4.ready);
    
        // Application Simulations
        // Use this example code to test various orders' updates
    }
}

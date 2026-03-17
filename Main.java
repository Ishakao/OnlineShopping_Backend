import java.util.*;

public class Main {


    public static void main(String[] args) {
        Product p1 = new Product("Sas", 109.99f, 0);
        Product p2 = new Product("Sussy", 59.99f, 1);

        System.out.println(p1.getPrice());
        System.out.println(p2.getPrice());
        System.out.println(p1.getTitle());
        System.out.println(p2.getTitle());
        System.out.println(p2.getId());
        System.out.println(p1.getId());
    }
}
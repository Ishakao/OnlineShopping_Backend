import java.util.*;

public class Main {
    public static class Product {
        private int id = 0;
        private String title = "";
        private float price = 0.0f;

        public String getTitle() {
            return title;
        }

        public float getPrice() {
            return price;
        }

        public int getId() {
            return id;
        }

        public void setTitle(String s) {
            title = s;
        }

        public void setPrice(float p) {
            price = p;
        }

        public Product(String t, float p, int i) {
            id = i;
            title = t;
            price = p;
        }

        public Product() {}
    }

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
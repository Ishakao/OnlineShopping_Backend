import java.util.ArrayList;
import java.util.HashMap;

public class Catalog {
    private static HashMap<String, Category> map = new HashMap<>();

    public int getQuantity() {
        return map.size();
    }

    public void add(String category, Product obj) {
        if (map.get(category) == null) {
            map.put(category, new Category());
        }
        map.get(category).addProduct(obj);
    }

    public void print() {
        for (String key : map.keySet()) {
            System.out.printf("%s [%d]:\n", key, map.get(key).getID());
            for (Product pr : map.get(key).getProducts()) {
                System.out.printf("  - %s\n", pr.getTitle());
            }
        }
    }
}

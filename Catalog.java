import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

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

    public Collection<Category> getCategories() {
        return map.values();
    }

    public void print() {
        for (String key : map.keySet()) {
            System.out.printf("%s [%d]:\n", key, map.get(key).getID());
            for (Product pr : map.get(key).getProducts()) {
                System.out.printf("  - %s |  %f\n", pr.getTitle(), pr.getPrice());
            }
        }
    }
}

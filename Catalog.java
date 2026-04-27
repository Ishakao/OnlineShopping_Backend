import java.util.Collection;
import java.util.HashMap;

public class Catalog implements Printable {
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

    @Override
    public void print() {
        showCatalog();
    }

    public Collection<Category> getCategories() {
        return map.values();
    }

    public void showCatalog() {
        map.keySet().forEach(key -> {
            System.out.printf("%s [%d]:\n", key, map.get(key).getID());
            map.get(key).print();
        });
    }
}

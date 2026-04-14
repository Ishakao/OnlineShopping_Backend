import java.util.ArrayList;

public class Category {
    private ArrayList<Product> products = new ArrayList<>();
    private int id = 0;

    public int getID() {
        return id;
    }

    public int getQuantity() {
        return products.size();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Category() {
        id = Main.IDUtility.getID(this);
    }
}

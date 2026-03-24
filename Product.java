import java.util.*;

public abstract class Product {
    protected int id = 0;
    private String title = "";
    private float price = 0.0f;
    protected static HashMap<Product, ArrayList<Product>> map = new HashMap<>();

    abstract float calcPrice(int quantity, float price);
    protected static int i = 0;
    int setId() {
        return i++;
    }

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

    public Product(String t, float p) {
        id = setId();
        title = t;
        price = p;
    }

    public Product() {}
}
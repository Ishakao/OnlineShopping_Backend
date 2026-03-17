public class Product {
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
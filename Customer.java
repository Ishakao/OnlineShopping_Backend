import java.sql.Array;
import java.util.ArrayList;

public class Customer extends Person implements Financeable {
    private double wallet = 0;
    private Main.FinanceStatus FinanceStatus;
    private ProductCart Cart = new ProductCart(this);

    public boolean deposit(double q) {
        if (q <= 0) return false;
        wallet += q;
        return true;
    }

    public boolean withdraw(double q) {
        if (q <= 0) return false;
        wallet -= q;
        return true;
    }

    public double checkBalance() {
        return wallet;
    }

    public boolean hasEnoughMoney() {
        return wallet >= Cart.amount();
    }

    public Main.FinanceStatus getFinanceStatus() {
        return FinanceStatus;
    }

    public void addProduct(Product p) {
        Cart.add(p);
    }

    private Product getProductByID(int id) {
        Product p = null;
        boolean t = false;
        for (Category c : Main.Catalog.getCategories()) {
            if (t) break;
            for (Product pr : c.getProducts(v -> true)) {
                if (pr.getId() == id) {
                    p = pr;
                    t = true;
                    break;
                }
            }
        }

        return p;
    }

    public void addProduct(int id) {
        Product p = getProductByID(id);
        if (p != null) {
            addProduct(p);
        }
    }

    public void removeProduct(Product p) {
        Cart.remove(p);
    }

    public void removeProduct(int id) {
        Product p = getProductByID(id);
        if (p != null) {
            removeProduct(p);
        }
    }

    public ProductCart getCart() {
        return Cart;
    }

    Customer(String n, String s, int b) {
        super(n, s, b);
    }
}

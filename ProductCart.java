import java.util.ArrayList;

public class ProductCart implements Payable{
    private ArrayList<Product> Cart = new ArrayList<>();
    private int id = 0;
    private Customer customer;
    private boolean paid = false;

    public void pay() {
        if (paid) return;
        if (customer.hasEnoughMoney()) {
            customer.withdraw(amount());
            paid = true;
            System.out.println("Purchased successfully");
        } else {
            System.out.println("Not enough money");
        }
    }

    public double amount() {
        double s = 0;
        for (Product p : Cart) { s += p.getPrice(); }
        return s;
    }

    public boolean isPaid() {
        return paid;
    }

    public void add(Product p) {
        Cart.add(p);
    }

    public void remove(Product p) {
        Cart.remove(p);
    }

    public ArrayList<Product> getProducts() {
        return Cart;
    }

    public ProductCart(Customer i) {
        id = Main.IDUtility.getID(this);
        customer = i;
    }
}

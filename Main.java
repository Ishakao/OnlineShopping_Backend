import java.util.*;
//
// https://accounts.google.com/v3/signin/accountchooser?continue=https%3A%2F%2Fdocs.google.com%2Fforms%2Fd%2Fe%2F1FAIpQLSfWbKuSDmAUAggSY8YjMW_9j5VXKznsmnsRKSyIqw_2AE11bA%2Fviewform%3Fusp%3Dheader&dsh=S303256082%3A1774346379493958&followup=https%3A%2F%2Fdocs.google.com%2Fforms%2Fd%2Fe%2F1FAIpQLSfWbKuSDmAUAggSY8YjMW_9j5VXKznsmnsRKSyIqw_2AE11bA%2Fviewform%3Fusp%3Dheader&ltmpl=forms&osid=1&passive=1209600&service=wise&flowName=GlifWebSignIn&flowEntry=ServiceLogin&ifkv=AT1y2_V_6A1z14cYUGDuHRBT7lnASXk4IHFjyURnKFQWqhglSfhcl1U7TkpYNZebJbVtj2Jb-ajGCA

public class Main {
    public static Catalog Catalog = new Catalog();
    public static utils IDUtility = new utils();

    enum FinanceStatus {
        pass;
    }

    enum SortType {
        Id,
        Title,
        Price
    }

    public static void main(String[] args) {
        Garden a = new Garden("Flower type 1", 3.15);
        Garden b = new Garden("Tree type 1", 15.99);
        Garden c = new Garden("Shovel type 1", 7.99);
        Electronics d = new Electronics("Computer type 1", 40.75);
        Electronics e = new Electronics("iPhone type 1", 25.99);
        Electronics f = new Electronics("TV type 1", 79.99);

        for (Category cat : Catalog.getCategories()) {
            cat.SetSortType(SortType.Price);
        }

        Catalog.print();

        Customer customer = new Customer("Ilya", "Tsaplin", 1488);
        customer.deposit(144);
        customer.addProduct(a);
        customer.addProduct(a);
        customer.addProduct(a);
        customer.addProduct(d);
        customer.addProduct(d);
        customer.addProduct(a);
        customer.addProduct(d);
        customer.addProduct(a);

        for (Product p : customer.getCart().getProducts()) {
            System.out.printf("%s | %f\n", p.getTitle(), p.getPrice());
        }

        System.out.println(customer.hasEnoughMoney());
        customer.getCart().pay();
        System.out.println(customer.getCart().amount());
        System.out.println(customer.checkBalance());
    }
}
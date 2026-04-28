import java.util.*;
//
// https://accounts.google.com/v3/signin/accountchooser?continue=https%3A%2F%2Fdocs.google.com%2Fforms%2Fd%2Fe%2F1FAIpQLSfWbKuSDmAUAggSY8YjMW_9j5VXKznsmnsRKSyIqw_2AE11bA%2Fviewform%3Fusp%3Dheader&dsh=S303256082%3A1774346379493958&followup=https%3A%2F%2Fdocs.google.com%2Fforms%2Fd%2Fe%2F1FAIpQLSfWbKuSDmAUAggSY8YjMW_9j5VXKznsmnsRKSyIqw_2AE11bA%2Fviewform%3Fusp%3Dheader&ltmpl=forms&osid=1&passive=1209600&service=wise&flowName=GlifWebSignIn&flowEntry=ServiceLogin&ifkv=AT1y2_V_6A1z14cYUGDuHRBT7lnASXk4IHFjyURnKFQWqhglSfhcl1U7TkpYNZebJbVtj2Jb-ajGCA

/*************************************
 *  Latest Log
 *  Category.java -> getProducts(...): has a Predicate for filtering products
 *  Category.java -> print(); has a stream() for print products
 *
 *************************************/

public class Main {
    public static Catalog Catalog = new Catalog();
    public static utils IDUtility = new utils();
    private static Scanner scanner = new Scanner(System.in);

    enum FinanceStatus {
        pass;
    }

    enum SortType {
        Id,
        Title,
        Price
    }

    private static Map<Integer, String> menuMoves = Map.of(
            0, "Exit",
            1, "Show Catalog",
            2, "Add product to cart",
            3, "Remove product from cart",
            4, "Show cart",
            5, "Pay",
            6, "Deposit",
            7, "Check balance"
    );

    public static void showUserMenu() {
        menuMoves.keySet().forEach(key->System.out.printf("%d: %s\n", key, menuMoves.get(key)));
    }

    private static void userMenuLoop() {
        Customer customer = new Customer("Ilya", "Tsaplin", 1488);

        while (true) {
            showUserMenu();

            int move = Integer.parseInt(scanner.nextLine());

            switch (move) {
                case 0: return;
                case 1: Catalog.showCatalog();
                case 2: {
                    int move2 = Integer.parseInt(scanner.nextLine());
                    customer.addProduct(move2);
                }
                case 3: {
                    int move2 = Integer.parseInt(scanner.nextLine());
                    customer.removeProduct(move2);
                }
                case 4: {
                    for (Product p : customer.getCart().getProducts()) {
                        System.out.printf("%s | %f\n", p.getTitle(), p.getPrice());
                    }
                }
                case 5: {
                    customer.getCart().pay();
                }
                case 6: {
                    int move2 = Integer.parseInt(scanner.nextLine());
                    customer.deposit(move2);
                }
                case 7: {
                    System.out.println(customer.checkBalance());
                }
            }
        }
    }

    private static void initProducts() {
        Garden a = new Garden("Flower type 1", 3.15);
        Garden b = new Garden("Tree type 1", 15.99);
        Garden c = new Garden("Shovel type 1", 7.99);
        Electronics d = new Electronics("Computer type 1", 40.75);
        Electronics e = new Electronics("iPhone type 1", 25.99);
        Electronics f = new Electronics("TV type 1", 79.99);
    }

    public static void main(String[] args) {
        initProducts();
        userMenuLoop();
    }
}
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
//
// https://accounts.google.com/v3/signin/accountchooser?continue=https%3A%2F%2Fdocs.google.com%2Fforms%2Fd%2Fe%2F1FAIpQLSfWbKuSDmAUAggSY8YjMW_9j5VXKznsmnsRKSyIqw_2AE11bA%2Fviewform%3Fusp%3Dheader&dsh=S303256082%3A1774346379493958&followup=https%3A%2F%2Fdocs.google.com%2Fforms%2Fd%2Fe%2F1FAIpQLSfWbKuSDmAUAggSY8YjMW_9j5VXKznsmnsRKSyIqw_2AE11bA%2Fviewform%3Fusp%3Dheader&ltmpl=forms&osid=1&passive=1209600&service=wise&flowName=GlifWebSignIn&flowEntry=ServiceLogin&ifkv=AT1y2_V_6A1z14cYUGDuHRBT7lnASXk4IHFjyURnKFQWqhglSfhcl1U7TkpYNZebJbVtj2Jb-ajGCA

/*************************************
 *  Latest Log
 *
 *  Using principles: S, O, D from SOLID
 *      S: Single Responsibility - already in use at all classes
 *      O: Open/Closed - already in use. Classes have stable interfaces and they can be changed without consequences
 *      D: Dependency Inversion - already in use. Classes methods don't using other classes.
 *
 *  Added filter products by name (menu move 9)
 *  Added filter products by price (menu move 10)
 *************************************/

public class Main {
    public static Catalog Catalog = new Catalog();
    public static utils IDUtility = new utils();
    public static Scanner scanner = new Scanner(System.in);

    enum FinanceStatus {
        pass;
    }

    enum SortType {
        Id,
        Title,
        Price
    }

    private static Map<Integer, String> menuMoves = new HashMap<>(Map.of(
            0, "Exit",
            1, "Show Catalog",
            2, "Add product to cart",
            3, "Remove product from cart",
            4, "Show cart",
            5, "Pay",
            6, "Deposit",
            7, "Check balance",
            8, "Set sort type",
            9, "Show products by name"
    ));

    public static void showUserMenu() {
        menuMoves.keySet().forEach(key->System.out.printf("%d: %s\n", key, menuMoves.get(key)));
    }

    private static void userMenuLoop() {
        Customer customer = new Customer("Ilya", "Tsaplin", 1488);

        while (true) {
            System.out.println();
            showUserMenu();
            System.out.println();

            int move = Integer.parseInt(scanner.nextLine());

            switch (move) {
                case 0: return;
                case 1: {
                    Catalog.showCatalog();
                    break;
                }
                case 2: {
                    if (customer.paid()) {
                        System.out.println("You can't add products after paid");
                        break;
                    }

                    String m = scanner.nextLine();
                    if (m.isEmpty()) continue;
                    int move2 = Integer.parseInt(m);
                    customer.addProduct(move2);
                    break;
                }
                case 3: {
                    if (customer.paid()) {
                        System.out.println("You can't remove products after paid");
                        break;
                    }

                    String m = scanner.nextLine();
                    if (m.isEmpty()) continue;
                    int move2 = Integer.parseInt(m);
                    customer.removeProduct(move2);
                    break;
                }
                case 4: {
                    for (Product p : customer.getCart().getProducts()) {
                        System.out.printf("%s | %f\n", p.getTitle(), p.getPrice());
                    }
                    break;
                }
                case 5: {
                    customer.getCart().pay();
                    break;
                }
                case 6: {
                    String m = scanner.nextLine();
                    if (m.isEmpty()) continue;
                    double move2 = Double.parseDouble(m);
                    customer.deposit(move2);
                    break;
                }
                case 7: {
                    customer.printBalance();
                    break;
                }
                case 8: {
                    System.out.printf("Select sort type:\n 1. ID\n2. Title\n3. Price\n");
                    int move2 = Integer.parseInt(scanner.nextLine());

                    if (move2 > 3 || move2 < 1) break;

                    for (Category c : Catalog.getCategories()) {
                        c.SetSortType(((move2 == 1) ? SortType.Id : ((move2 == 2) ? SortType.Price : SortType.Title)));
                    }

                    break;
                }
                case 9: {
                    String move2 = scanner.nextLine();

                    AtomicInteger i = new AtomicInteger(0);

                    for (Category c : Catalog.getCategories()) {
                        c.getProducts(P -> P.getTitle().contains(move2)).stream().forEach(p -> {System.out.printf("[%d] %s (%f)\n", p.getId(), p.getTitle(), p.getPrice());
                            i.getAndIncrement();
                        });
                    }

                    if (i.get() == 0) {
                        System.out.printf("No products with name \"%s\"\n", move2);
                    }

                    break;
                }
                case 10: {
                    System.out.println("Type filter price:");
                    float move2 = Float.parseFloat(scanner.nextLine());
                    System.out.println("> or <:");
                    boolean move3 = scanner.nextLine().equals("<");

                    AtomicInteger i = new AtomicInteger(0);

                    for (Category c : Catalog.getCategories()) {
                        c.getProducts(P -> move3 ? P.getPrice() > move2 : P.getPrice() < move2).stream().forEach(p -> {System.out.printf("[%d] %s (%f)\n", p.getId(), p.getTitle(), p.getPrice());
                            i.getAndIncrement();
                        });
                    }

                    if (i.get() == 0) {
                        System.out.printf("No products with price %s than %f\n", move3 ? "less" : "more", move2);
                    }

                    break;
                }
                case 11: {
                    ArrayList<ArrayList<Product>> Orders = customer.getOrders();
                    for (int i = 0; i < Orders.size(); i++) {
                        AtomicReference<Double> total = new AtomicReference<>((double) 0);
                        Orders.get(i).stream().forEach(p-> total.updateAndGet(v -> new Double((double) (v + p.getPrice()))));
                        System.out.printf("Order %d   |   Total: %f:\n", i, total.get());
                        Orders.get(i).stream().forEach(p -> System.out.printf("  - [%d] %s | %f\n", p.getId(), p.getTitle(), p.getPrice()));
                    }
                    break;
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
        menuMoves.put(10, "Show products filtered by price");
        menuMoves.put(11, "Show orders history");
        userMenuLoop();
    }
}
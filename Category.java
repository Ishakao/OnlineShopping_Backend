import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Category implements Printable {
    private ArrayList<Product> products = new ArrayList<>();
    private int id = 0;
    private Main.SortType sortType = Main.SortType.Id;

    private void update() {
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product lhs, Product rhs) {
                if (sortType == Main.SortType.Id) {
                    return Integer.compare(lhs.getId(), rhs.getId());
                } else if (sortType == Main.SortType.Price) {
                    return Double.compare(lhs.getPrice(), rhs.getPrice());
                } else {
                    if (lhs.getTitle().length() == rhs.getTitle().length()) {
                        for (int i = 0; i < lhs.getTitle().length(); i++) {
                            if (lhs.getTitle().charAt(i) == rhs.getTitle().charAt(i)) {
                                continue;
                            }

                            return Character.compare(lhs.getTitle().charAt(i), rhs.getTitle().charAt(i));
                        }

                        return 0;
                    } else {
                        return Integer.compare(lhs.getTitle().length(), rhs.getTitle().length());
                    }
                }
            }
        });
    }

    @Override
    public void print() {
        products.stream().forEach(x -> System.out.printf("  - (%d) %s |  %f\n", x.getId(), x.getTitle(), x.getPrice()));
    }

    public int getID() {
        return id;
    }

    public int getQuantity() {
        return products.size();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> getProducts(Predicate<Product> condition) {
        return products.stream().filter(condition).collect(Collectors.toList());
    }

    public void SetSortType(Main.SortType type) {
        sortType = type;
        update();
    }

    public Category() {
        id = Main.IDUtility.getID(this);
    }
}

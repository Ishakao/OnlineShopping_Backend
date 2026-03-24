import java.util.*;

public class Garden extends Product {
    @Override
    float calcPrice(int quantity, float price) {
        return quantity * price;
    }

    Garden() {
        super();
    }

    public Garden(String t, float p) {
        super(t, p);
        if (map.get(this) == null) {
            map.put(this, new ArrayList<>());
        }
        map.get(this).add(this);
    }
}
import java.util.*;

public class Electronics extends Product {
    @Override
    float calcPrice(int quantity, float price) {
        return quantity * price;
    }


    Electronics() {
        super();
    }

    public Electronics(String t, float p) {
        super(t, p);
        if (map.get(this) == null) {
            map.put(this, new ArrayList<>());
        }
        map.get(this).add(this);
    }
}

public class utils {
    private static int LastID = 0;
    private static int CategoryID = 0;
    private static int PersonID = 0;
    private static int CartID = 0;

    public int getID(Object p) {
        if (p instanceof Product) return LastID++;
        if (p instanceof Category) return CategoryID++;
        if (p instanceof Person) return PersonID++;
        if (p instanceof ProductCart) return CartID++;
        return -1;
    }
}
public class Railroad extends Property {
    static int numOwned;
    int[] rentPayments = { 0, 25, 50, 100, 200 };

    public Railroad(String name) {
        super(name, 200, 0);
        numOwned = 0;
    }

    public int getRent() {
        return rentPayments[numOwned];
    }

    public static void increaseNumOwned() {
        numOwned++;
    }

    public String toString() {
        return getName() + " [" + numOwned + "]";
    }

}
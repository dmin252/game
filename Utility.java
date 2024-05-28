public class Utility extends Property {
    static int numOwned = 0;
    private Die dice;

    public Utility(String name, Die dice){
        super(name, 150, 0);
        this.dice = dice;
    }

    public int getRent() {
        if (numOwned == 1) {
            return 4 * dice.currentRoll();
        } else {
            return 10 * dice.currentRoll();
        }
    }

    public static void increaseNumOwned() {
        numOwned++;
    }

    public String toString() {
        return getName() + " [" + numOwned + "]";
    }

}
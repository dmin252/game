public class Railroad extends Property {

    public Railroad(String name) {
        super(name, 200);
    }

    public int getCost() {
        int numRailroads = 0;
        for (Property p : getOwner().getProperties()) {
            if (p instanceof Railroad) {
                numRailroads++;
            }
        }
        int[] rents = { 0, 25, 50, 100, 200 };
        return rents[numRailroads];
    }

}
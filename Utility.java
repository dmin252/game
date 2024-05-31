public class Utility extends Property {

    public Utility(String name) {
        super(name, 150);
    }

    public int getCost() {
        int numUtilities = 0;
        for (Property p : getOwner().getProperties()) {
            if (p instanceof Utility) {
                numUtilities++;
            }
        }
        int rollResult = Dice.roll();
        if (numUtilities == 1) {
            System.out.println("Player rolled a " + rollResult + " and owes $" + 4 * rollResult + " to the owner.");
            return 4 * rollResult;
        } else {
            System.out.println("Player rolled a " + rollResult + " and owes $" + 10 * rollResult + " to the owner.");
            return 10 * rollResult;
        }
    }

}
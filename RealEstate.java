public class RealEstate extends Property {
    private int numberHouses;
    static final int MAX_HOUSES = 5;
    private String color;

    public RealEstate(String name, int purchasePrice, String color) {
        super(name, purchasePrice);
        this.color = color;
        numberHouses = 0;
    }

    public String getColor() {
        return color;
    }

    public int getNumberHouses() {
        return numberHouses;
    }

    public void incrementNumberHouses() {
        if (numberHouses < MAX_HOUSES) {
            numberHouses++;
        } else {
            System.out.println("Cannot add more than " + MAX_HOUSES + " houses.");
        }
    }

    public int getHouseCost() {
        return 50;  // Example house cost, can vary
    }

    @Override
    public int getCost() {
        return 10 + 5 * numberHouses;
    }

    @Override
    public String toString() {
        return "Property " + getName() + " owned by " + getOwner().getName() + " with " + numberHouses + " houses";
    }
}

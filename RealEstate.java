public class RealEstate extends Property {
    private int numberHouses;
    static final int MAX_HOUSES = 5;
    private String color;
    private int houseCost;
    private int[] rents; 

    public RealEstate(String name, int purchasePrice, String color, int houseCost, int[] rents) {
        super(name, purchasePrice);
        this.color = color;
        numberHouses = 0;
        this.houseCost = houseCost;
        this.rents = rents;
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

    public void setNumberHouses(int numberHouses) {
        this.numberHouses = numberHouses;
    }

    public int getHouseCost() {
        return houseCost;  // Example house cost, can vary
    }

    @Override
    public int getCost() {
        return rents[numberHouses];
    }

    @Override
    public String toString() {
        return "Property " + getName() + " owned by " + getOwner().getName() + " with " + numberHouses + " houses";
    }
    
}

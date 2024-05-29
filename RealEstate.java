public class RealEstate extends Property{
    private int numberHouses;

    public RealEstate(String name, int purchasePrice) {
        super(name, purchasePrice);
        numberHouses = 0;
    }

    public int getNumberHouses() {
        return numberHouses;
    }

    public void setNumberHouses(int numberHouses) {
        this.numberHouses = numberHouses;
    }

    public void incrementNumberHouses() {
        numberHouses++;
    }

    public int getCost() {
        return 10 + 5 * numberHouses;
    }
    
    public String toString() {
        return "Property " + getName() + " owned by " + getOwner().getName() + " with " + numberHouses + " houses";
    }
}

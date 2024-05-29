public class Property extends Square {
    // instance variables
    private int purchasePrice;
    private Player owner;

    public Property(String name, int purchasePrice) {
        super(name);
        this.purchasePrice = purchasePrice;
        owner = null;
    }

    public int getpurchasePrice() {
        return purchasePrice;
    }

    public int getCost() {
        return 10;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public String toString() {
        return "Property " + getName() + " owned by " + owner.getName();
    }

}
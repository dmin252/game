public class Property extends Square {
    // instance variables
    private int price;
    private int rent;
    private Player owner;

    public Property(String name, int price) {
        super(name);
        this.price = price;
        this.owner = null;
        rent = 0;
    }

    public int getPrice() {
        return price;
    }

    public int getRent() {
        return rent;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public String toString() {
        return "$" + price + " " + getName();
    }

}
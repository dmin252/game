import java.util.ArrayList;

public class Player {
    ArrayList<Property> properties = new ArrayList<Property>();
    private String name;
    private int money;
    private int position;
    private boolean inJail;
    private int jailTurns;

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
        position = 0;
        inJail = false;
        jailTurns = 0;
    }

    public String getPropertiesNames() {
        String names = "";
        for (Property p : properties) {
            names += p.getName() + ", ";
        }
        return names;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public void addProperty(Property p) {
        properties.add(p);
    }

    public void removeProperty(int indexProperty) {
        properties.remove(indexProperty);
    }
    public boolean isInJail() {
        return inJail;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public int getJailTurns() {
        return jailTurns;
    }

    public void setJailTurns(int jailTurns) {
        this.jailTurns = jailTurns;
    }
}

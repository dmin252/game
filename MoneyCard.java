public class MoneyCard extends Card {
    private int amount;

    public MoneyCard(String description, int amount) {
        super(description);
        this.amount = amount;
    }

    @Override
    public void applyEffect(Player player) {
        player.setMoney(player.getMoney() + amount);
        System.out.println(player.getName() + " receives " + amount + " money");
    }
}

public class Chance extends Square {
    private CardDeck deck;

    public Chance(CardDeck deck) {
        super("Chance");
        this.deck = deck;
    }

    public void drawCard(Player player) {
        Card card = deck.drawCard();
        System.out.println(player.getName() + " drew a Chance card: " + card.getDescription());
        card.applyEffect(player);
    }

}

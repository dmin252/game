public class CommunityChest extends Square {
    private CardDeck deck;

    public CommunityChest(CardDeck deck) {
        super("Community Chest");
        this.deck = deck;
    }

    public void drawCard(Player player) {
        Card card = deck.drawCard();
        System.out.println(player.getName() + " drew a Community Chest card: " + card.getDescription());
        card.applyEffect(player);
    }
}

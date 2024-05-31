import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class CardDeck {
    private Queue<Card> cards;

    public CardDeck() {
        cards = new LinkedList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card drawCard() {
        Card card = cards.poll();
        cards.add(card); 
        return card;
    }

    public void shuffle() {
        for (int i = 0; i < cards.size(); i++) {
            int rand = (int) (Math.random() * cards.size());
            Card temp = ((LinkedList<Card>) cards).get(i);
            ((LinkedList<Card>) cards).set(i, ((LinkedList<Card>) cards).get(rand));
            ((LinkedList<Card>) cards).set(rand, temp);
        }
    }
    
}

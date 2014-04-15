package orihay.cards;

import java.util.List;

public class Deck {
  private List<Card> cards;

  public Deck(List<Card> cards) {
    this.cards = cards;
  }

  public List<Card> getCards() {
    return this.cards;
  }

  public Card get(int i) {
    return this.cards.get(i);
  }

  public void print() {
    for (Card c : cards) {
      c.print();
    }
  }
}

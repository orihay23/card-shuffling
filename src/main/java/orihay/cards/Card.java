package orihay.cards;

public class Card {
  private String suit;
  private int rank;

  public Card(String suit, int rank) {
    this.suit = suit;
    this.rank = rank;
  }

  public String getSuit() {
    return this.suit;
  }

  public int getRank() {
    return this.rank;
  }
}

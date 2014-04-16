package orihay;

import java.util.ArrayList;
import java.util.Random;

import orihay.cards.Card;
import orihay.cards.Deck;
import orihay.cards.Rank;
import orihay.cards.Suit;
import orihay.shuffle.Shuffle;

public class Main {

  /**
   * @param args
   */
  public static void main(String[] args) {
    ArrayList<Card> cardList = new ArrayList<Card>();
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        cardList.add(new Card(suit, rank));
      }
    }
    Deck full = new Deck(cardList);
    System.out.println("DECK:");
    full.print();
    Deck shuffled = Shuffle.withRand(full, new Random().nextLong());
    System.out.println("SHUFFLED:");
    shuffled.print();
    System.out.println("DECK UNMODIFIED:");
    full.print();
  }

}

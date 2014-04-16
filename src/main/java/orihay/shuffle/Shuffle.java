package orihay.shuffle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import orihay.cards.Card;
import orihay.cards.Deck;
import orihay.cards.Rank;
import orihay.cards.Suit;

public class Shuffle {
  public static void main(String[] args) {
    Card C1 = new Card(Suit.Clubs, Rank.Ace);
    Card D2 = new Card(Suit.Diamonds, Rank.Two);
    Card S10 = new Card(Suit.Spades, Rank.Ten);
    Card H11 = new Card(Suit.Hearts, Rank.Jack);
    Card S11 = new Card(Suit.Spades, Rank.Jack);
    ArrayList<Card> list = new ArrayList<Card>();
    list.add(C1);
    list.add(D2);
    list.add(S10);
    list.add(H11);
    list.add(S11);
    Deck unshuffled = new Deck(list);
    System.out.println("Unshuffled:");
    unshuffled.print();
    Random random = new Random();
    long seed = random.nextLong();
    int i = 0;
    while (i < 6) {
      System.out.println("Shuffled");
      withRand(unshuffled, seed).print();
      seed = random.nextLong();
      i++;
    }
  }

  public static Deck withRand(Deck d, long seed) {
    Random rand = new Random(seed);
    List<Card> cards = d.getCards();
    Deck shuffled = null;
    if (cards.size() > 1) {
      shuffled = new Deck(sort(cards, rand));
    } else {
      shuffled = d;
    }
    return shuffled;
  }

  private static List<Card> merge(
      List<Card> first,
      List<Card> second,
      Random rand) {
    int oneSize = 0;
    int twoSize = 0;
    ArrayList<Card> merged = new ArrayList<Card>();
    while (oneSize < first.size() || twoSize < second.size()) {
      if (oneSize == first.size()) {
        merged.addAll(second.subList(twoSize, second.size()));
        twoSize = second.size();
      } else if (twoSize == second.size()) {
        merged.addAll(first.subList(oneSize, first.size()));
        oneSize = first.size();
      } else {
        if (rand.nextBoolean()) {
          merged.add(first.get(oneSize));
          oneSize++;
        } else {
          merged.add(second.get(twoSize));
          twoSize++;
        }
      }
    }
    return merged;
  }

  private static List<Card> sort(List<Card> cards, Random rand) {
    int floor = (int) Math.floor(cards.size() / 2);
    if (cards.size() == 2) {
      return sortTwoCards(cards.get(0), cards.get(1), rand);
    } else if (cards.size() == 1) {
      return cards;
    } else {
      List<Card> first = cards.subList(0, floor);
      List<Card> second = cards.subList(floor, cards.size());
      return merge(sort(first, rand), sort(second, rand), rand);
    }
  }

  private static List<Card> sortTwoCards(Card one, Card two, Random rand) {
    ArrayList<Card> sorted = new ArrayList<Card>();
    if (rand.nextBoolean()) {
      sorted.add(one);
      sorted.add(two);
    } else {
      sorted.add(two);
      sorted.add(one);
    }
    return sorted;
  }
}

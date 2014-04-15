package orihay.shuffle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import orihay.cards.Card;
import orihay.cards.Deck;

public class Shuffle {

  public static Deck withRand(Deck d, long seed) {
    List<Card> cards = d.getCards();
    if (cards.size() > 1) {
      sort(cards, seed);
    }
    merge(cards, seed);
    return d;
  }

  private static List<Card> merge(List<Card> first, List<Card> second, long seed) {

    if (cards.size() == 2) {
      return sort(cards.get(0), cards.get(1), seed);
    } else {
      return merge(cards, seed);
    }
  }

  private static List<Card> sort(List<Card> cards, long seed) {
    int floor = (int) Math.floor(cards.size() / 2);
    List<Card> first = cards.subList(0, floor);
    List<Card> second = cards.subList(floor + 1, cards.size() - 1);
    merge(sort(first, seed), sort(second, seed), seed);
  }

  private static List<Card> sort(Card one, Card two, long seed) {
    ArrayList<Card> sorted = new ArrayList<Card>();
    if (decide(seed)) {
      sorted.add(one);
      sorted.add(two);
    } else {
      sorted.add(two);
      sorted.add(one);
    }
    return sorted;
  }

  private static boolean decide(long seed) {
    Random random = new Random(seed);
    return random.nextBoolean();
  }
}

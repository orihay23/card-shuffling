package orihay.shuffle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import orihay.cards.Card;
import orihay.cards.Deck;

public class Shuffle {
  public static Deck withRand(Deck d, long seed) {
    List<Card> cards = d.getCards();
    Deck shuffled = null;
    if (cards.size() > 1) {
      shuffled = new Deck(sort(cards, seed));
    } else {
      shuffled = d;
    }
    return d;
  }

  private static List<Card> merge(List<Card> first, List<Card> second, long seed) {
    int oneSize = 0;
    int twoSize = 0;
    ArrayList<Card> merged = new ArrayList<Card>();
    while (oneSize != first.size() && twoSize != second.size()) {
      if (oneSize != first.size() || twoSize != second.size()) {
        if (decide(seed)) {
          merged.add(first.get(oneSize));
          oneSize++;
        } else {
          merged.add(second.get(twoSize));
          twoSize++;
        }
      } else if (oneSize == first.size()) {
        merged.addAll(second.subList(twoSize, second.size() - 1));
        twoSize = second.size();
      } else {
        merged.addAll(first.subList(oneSize, first.size() - 1));
        oneSize = first.size();
      }
    }
    return merged;
  }

  private static List<Card> sort(List<Card> cards, long seed) {
    int floor = (int) Math.floor(cards.size() / 2);
    if (cards.size() == 2) {
      return sortTwoCards(cards.get(0), cards.get(1), seed);
    } else if (cards.size() == 1) {
      return cards;
    } else {
      List<Card> first = cards.subList(0, floor);
      List<Card> second = cards.subList(floor + 1, cards.size() - 1);
      return merge(sort(first, seed), sort(second, seed), seed);
    }
  }

  private static List<Card> sortTwoCards(Card one, Card two, long seed) {
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

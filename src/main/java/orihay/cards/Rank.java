package orihay.cards;

public enum Rank {
  One("1"),
  Two("2"),
  Three("3"),
  Four("4"),
  Five("5"),
  Six("6"),
  Seven("7"),
  Eight("8"),
  Nine("9"),
  Ten("10"),
  Jack("J"),
  Queen("Q"),
  King("K"),
  Ace("A");

  private String label;

  private Rank(String label) {
    this.label = label;
  }

  public String getLabel() {
    return this.label;
  }
}

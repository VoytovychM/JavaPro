package lesson20240320.cards;

public abstract class Card implements Comparable<Card>{

    public abstract int getId();

    public int compareTo(Card o) {
        return this.getId() - o.getId();
    }

}

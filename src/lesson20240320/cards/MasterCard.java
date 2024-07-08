package lesson20240320.cards;

public class MasterCard extends Card {

    private int masterCardId;

    public MasterCard(int masterCardId) {
        this.masterCardId = masterCardId;
    }

    @Override
    public int getId() {
        return masterCardId;
    }

    @Override
    public String toString() {
        return "lesson20240320.cards.MasterCard{" +
                "masterCardId=" + masterCardId +
                '}';
    }
}

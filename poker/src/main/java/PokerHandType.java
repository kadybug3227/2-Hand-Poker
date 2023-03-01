/*Enum class of Poker hand
Gives each type of poker hand a name and a point value, which is used to make the first comparison (which would be
the outcome if there were no matching poker hands

 */

public enum PokerHandType {
    HIGH_CARD(1, "High Card"),
    PAIR(2, "Pair"),
    TWO_PAIR(3, "Two pair"),
    THREE_OF_A_KIND(4, "Three of a kind"),
    STRAIGHT(5, "Straight"),
    FLUSH(6, "Flush"),
    FULL_HOUSE(7, "Full house"),
    FOUR_OF_A_KIND(8, "Four of a kind"),
    STRAIGHT_FLUSH(9, "Straight flush");




    //private field
    private final int pointValue;
    private final String pokerHandName;


    //constructor
    private PokerHandType(int pointValue, String pokerHandName) {
        this.pointValue = pointValue;
        this.pokerHandName = pokerHandName;
    }

    public int getPointValue() {
        return pointValue;
    }
    public String getPokerHandName() {
        return pokerHandName;
    }
}
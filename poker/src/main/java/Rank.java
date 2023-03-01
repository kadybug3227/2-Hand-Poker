//Enum rank, to store all the constant variables of the ranks of cards 2 - Ace;
// containing both string and number value
public enum Rank {

    TWO(2, "2"), THREE(3, "3"), FOUR(4, "4"),
    FIVE(5, "5"), SIX(6, "6"), SEVEN(7, "7"),
    EIGHT(8, "8"), NINE(9, "9"), TEN(10, "10"),
    JACK(11, "Jack"), QUEEN(12, "Queen"), KING(13, "King"),
    ACE(14, "Ace");

    //private field
    private final int rankValue;
    private final String rankString;

    //constructor
    private Rank(int rankValue, String rankString){
        this.rankValue = rankValue;
        this.rankString = rankString;
    }


    //public methods
    public int getRankValue(){
        return rankValue;
    }

    public String getRankString(){
        return rankString;
    }
}
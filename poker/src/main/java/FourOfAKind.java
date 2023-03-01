import java.util.ArrayList;

public class FourOfAKind extends PokerHand {

    private final int fourSpreadValue;
    private final String fourSpreadValueString;


    public FourOfAKind(PokerHandType pokerHandType, ArrayList<Integer> cardsRank,
                       ArrayList<String> cardsRankString, ArrayList<Integer> tempCardsRankSorted,
                       int fourSpreadValue, String fourSpreadValueString){
        super(pokerHandType);

        this.cardsRank = cardsRank;
        this.cardsRankString = cardsRankString;
        this.tempCardsRankSorted = tempCardsRankSorted;
        this.fourSpreadValue = fourSpreadValue;
        this.fourSpreadValueString = fourSpreadValueString;
    }


    public int getFourSpreadValue(){
        return fourSpreadValue;
    }
    public String getFourSpreadValueString(){
        return fourSpreadValueString;
    }

    public String toString(){
        String str = "";
        str +=  this.pokerHandType.getPokerHandName() + " of " + getFourSpreadValueString() + "s";

        return str;
    }
}

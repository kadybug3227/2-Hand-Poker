import java.util.ArrayList;

public class Pair extends PokerHand {


    private final String pairValueString;
    private final int pairValue;


    public Pair(PokerHandType pokerHandType, ArrayList<Integer> cardsRank,
                ArrayList<String> cardsRankString, ArrayList<Integer> tempCardsRankSorted, String pairValueString,
                int pairValue){

        super(pokerHandType);
        this.cardsRank = cardsRank;
        this.cardsRankString = cardsRankString;
        this.tempCardsRankSorted = tempCardsRankSorted;
        this.pairValueString = pairValueString;
        this.pairValue = pairValue;
    }




    public String getPairValueString(){
        return pairValueString;
    }

    public int getPairValue(){
        return pairValue;
    }


    public String toString(){
        String str = "";
        str +=  this.pokerHandType.getPokerHandName() + " of " + getPairValueString() + "s";

        return str;
    }
}

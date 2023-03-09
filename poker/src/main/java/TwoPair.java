import java.util.ArrayList;

public class TwoPair extends PokerHand {


    private final int pair1Value;
    private final String pair1ValueString;

    private final int pair2Value;
    private final String pair2ValueString;

    private final int lastCardValue;
    private final String lastCardValueString;


    public TwoPair(PokerHandType pokerHandType, ArrayList<Integer> cardsRank,
                   ArrayList<String> cardsRankString, ArrayList<Integer> tempCardsRankSorted,
                   int pair1Value, String pair1ValueString,
                   int pair2Value, String pair2ValueString,
                   int lastCardValue, String lastCardValueString){

        super(pokerHandType);
        this.cardsRank = cardsRank;
        this.cardsRankString = cardsRankString;
        this.tempCardsRankSorted = tempCardsRankSorted;
        this.pair1Value = pair1Value;
        this.pair1ValueString = pair1ValueString;
        this.pair2Value = pair2Value;
        this.pair2ValueString = pair2ValueString;
        this.lastCardValue = lastCardValue;
        this.lastCardValueString = lastCardValueString;

    }


    public String getPair1ValueString(){
        return pair1ValueString;
    }


    public int getPairValue(){
        return pair1Value;
    }

    public String getPair2ValueString(){
        return pair2ValueString;
    }


    public int getPair2Value(){
        return pair2Value;
    }


    public String getLastCardValueString(){
        return lastCardValueString;
    }


    public int getLastCardValue(){
        return lastCardValue;
    }


    public String toString(){
        String str = "";
        str +=  this.pokerHandType.getPokerHandName() + " of " + getPair1ValueString() + "s" +
        " and " + getPair2ValueString() + "s";

        return str;
    }
}

import java.util.ArrayList;

public class FullHouse extends PokerHand {

    private final int threeSpreadValue;
    private final String threeSpreadValueString;

    private final int pairValue;
    private final String pairValueString;


    public FullHouse(PokerHandType pokerHandType, ArrayList<Integer> cardsRank,
                     ArrayList<String> cardsRankString, ArrayList<Integer> tempCardsRankSorted,
                     int threeSpreadValue, String threeSpreadValueString, int pairValue, String pairValueString){
        super(pokerHandType);

        this.cardsRank = cardsRank;
        this.cardsRankString = cardsRankString;
        this.tempCardsRankSorted = tempCardsRankSorted;
        this.threeSpreadValue = threeSpreadValue;
        this.threeSpreadValueString = threeSpreadValueString;
        this.pairValue = pairValue;
        this.pairValueString = pairValueString;
    }



    public int getThreeSpreadValue(){
        return threeSpreadValue;
    }
    public String getThreeSpreadValueString(){
        return threeSpreadValueString;
    }

    public int pairValue(){
        return pairValue;
    }
    public String getPairValueString(){
        return pairValueString;
    }


    public String toString(){
        String str = "";
        str +=  this.pokerHandType.getPokerHandName() + " of " + getThreeSpreadValueString() + "s" +
                " over " + getPairValueString() + "s";
        return str;
    }
}

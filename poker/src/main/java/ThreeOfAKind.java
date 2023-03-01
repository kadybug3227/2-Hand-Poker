import java.util.ArrayList;

public class ThreeOfAKind extends PokerHand {


    private final int threeSpreadValue;
    private final String threeSpreadValueString;


    public ThreeOfAKind(PokerHandType pokerHandType, ArrayList<Integer> cardsRank,
                        ArrayList<String> cardsRankString, ArrayList<Integer> tempCardsRankSorted,
                        int threeSpreadValue, String threeSpreadValueString){
        super(pokerHandType);

        this.cardsRank = cardsRank;
        this.cardsRankString = cardsRankString;
        this.tempCardsRankSorted = tempCardsRankSorted;
        this.threeSpreadValue = threeSpreadValue;
        this.threeSpreadValueString = threeSpreadValueString;
    }


    public int getThreeSpreadValue(){
        return threeSpreadValue;
    }
    public String getThreeSpreadValueString(){
        return threeSpreadValueString;
    }


    public String toString(){
        String str = "";

        str +=  this.pokerHandType.getPokerHandName() + " of " + getThreeSpreadValueString()+ "s";

        return str;
    }
}

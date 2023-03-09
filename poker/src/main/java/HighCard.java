import java.util.ArrayList;

public class HighCard extends PokerHand {


    private final String highValueString;
    private final int highValue;


    public HighCard(PokerHandType pokerHandType, ArrayList<Integer> cardsRank,
                    ArrayList<String> cardsRankString, ArrayList<Integer> tempCardsRankSorted, String highCard,
                    int highValue){

        super(pokerHandType);

        this.cardsRank = cardsRank;
        this.cardsRankString = cardsRankString;
        this.tempCardsRankSorted = tempCardsRankSorted;
        this.highValueString = highCard;
        this.highValue = highValue;
    }



    public String getHighValueString(){
        return highValueString;
    }

    public int getHighValue(){
        return highValue;
    }

    public String toString(){
        String str = "";
        str +=  this.pokerHandType.getPokerHandName() + " of " + getHighValueString();

        return str;
    }
}

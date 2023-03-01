import java.util.ArrayList;

public class HighCard extends PokerHand {


    private final String highValueString;
    private final int highValue;
    //protected   ArrayList<String> cardsRankString = new ArrayList<>();
    //protected   ArrayList<Integer> tempCardsRankSorted = new ArrayList<>();
    //made at the creation of pokerHand obj; the rest of the classes should inherited these exact list????

//so we have an array of cards...from the PokerHand class from the hand class
    public HighCard(PokerHandType pokerHandType, ArrayList<Integer> cardsRank,
                    ArrayList<String> cardsRankString, ArrayList<Integer> tempCardsRankSorted, String highCard,
                    int highValue){

        super(pokerHandType);

        //private final PokerHandType pokerHandType;
        //calling the super () so take care of this
        // //this.pokerHandType = PokerHandType.HIGH_CARD; //Not entirely sure if this is necessary... maybe cuz to create one

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

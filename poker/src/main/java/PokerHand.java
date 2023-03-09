import java.lang.reflect.Array;
import java.util.ArrayList;

public class PokerHand{
    //PokerHand serves as a parent class for all the different poker hand objects: 2pair obj; full house obj, etc

    protected final PokerHandType pokerHandType;
    protected ArrayList<Integer> cardsRank;
    protected  ArrayList<String> cardsRankString;
    protected ArrayList<Integer> tempCardsRankSorted;


    public PokerHand(PokerHandType pokerHandType) {
        this.pokerHandType = pokerHandType;

    }


    //public methods

    protected PokerHandType getPokerHandType(){
        return pokerHandType;
    }
    protected int getPokerHandTypeHandNameValue(){
        return pokerHandType.getPointValue();
    }

    protected int getPokerHandTypePointValue(){
        return pokerHandType.getPointValue();
    }

}

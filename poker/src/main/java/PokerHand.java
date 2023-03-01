import java.lang.reflect.Array;
import java.util.ArrayList;

//SHOULD this be an abstract class???
public class PokerHand{
    //PokerHand serves as a parent class for all the different poker hand objects: 2pair obj; full house obj, etc

    protected final PokerHandType pokerHandType;
    protected ArrayList<Integer> cardsRank;
    protected  ArrayList<String> cardsRankString;
    protected ArrayList<Integer> tempCardsRankSorted;



    //should they have arrayLists of ints(for rank values) and String for suits...
    //for ranks... what about the faceCards??
    //a String array for rankString?
    //these can be given at creation???
    //the hand types are already declared from cards that actually exist (have been dealt)

   // private ArrayList<Card> straightCards;  //probably will need this for all poker hand classes...
    //because... the TIES!!!! BUT NO- it's an empty array, it will never have cards; ONLY way to get cards is to be
    //dealt cards, find some other idea for ties....

    public PokerHand(PokerHandType pokerHandType) { //}, , ArrayList<String> cardsRankString,
                     //ArrayList<Integer> tempCardsRankSorted) {
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

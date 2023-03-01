import java.util.ArrayList;

public class Flush extends PokerHand {

    private String flushSuitString;
    private ArrayList<String> cardsRankSortedString;


    public Flush(PokerHandType pokerHandType, ArrayList<Integer> cardsRank,
                 ArrayList<String> cardsRankString, ArrayList<Integer> tempCardsRankSorted, String flushSuitString,
                 ArrayList<String> cardsRankSortedString){
        super(pokerHandType);

        this.cardsRank = cardsRank;
        this.cardsRankString = cardsRankString;
        this.tempCardsRankSorted = tempCardsRankSorted;
        this.flushSuitString = flushSuitString;
        this.cardsRankSortedString = cardsRankSortedString;
    }



    public String toString(){
        String flushString = pokerHandType.getPokerHandName() + " of ";

        for (int i = 0; i < cardsRankSortedString.size(); i++){
            flushString += cardsRankSortedString.get(i) + " ";
        }
        flushString +=  "of " + flushSuitString;
        return flushString;
    }

}

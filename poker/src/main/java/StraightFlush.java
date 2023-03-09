import java.util.ArrayList;

public class StraightFlush extends PokerHand {

    private String straightFlushSuitString;
    private ArrayList<String> cardsRankSortedString;

    public StraightFlush(PokerHandType pokerHandType, ArrayList<Integer> cardsRank,
                         ArrayList<String> cardsRankString, ArrayList<Integer> tempCardsRankSorted,
                         String straightFlushSuitString,
                         ArrayList<String> cardsRankSortedString){

        super(pokerHandType);

        this.cardsRank = cardsRank;
        this.cardsRankString = cardsRankString;
        this.tempCardsRankSorted = tempCardsRankSorted;
        this.straightFlushSuitString = straightFlushSuitString;
        this.cardsRankSortedString = cardsRankSortedString;
    }


    public String toString(){
        String straightFlushString = pokerHandType.getPokerHandName() + " of ";

        for (int i = 0; i < cardsRankSortedString.size(); i++){
            straightFlushString += cardsRankSortedString.get(i) + " ";
        }
        straightFlushString +=  "of " + straightFlushSuitString;
        return straightFlushString;
    }

}

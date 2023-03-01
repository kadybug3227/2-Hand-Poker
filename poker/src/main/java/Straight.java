import java.util.ArrayList;

public class Straight extends PokerHand {

    private ArrayList<String> cardsRankSortedString;


    public Straight(PokerHandType pokerHandType, ArrayList<Integer> cardsRank,
                    ArrayList<String> cardsRankString, ArrayList<Integer> tempCardsRankSorted,
                    ArrayList<String> cardsRankSortedString){
        super(pokerHandType);

        this.cardsRank = cardsRank;
        this.cardsRankString = cardsRankString;
        this.tempCardsRankSorted = tempCardsRankSorted;
        this.cardsRankSortedString = cardsRankSortedString;
    }


    public String toString(){
        String straightString = "";

        for (int i = 0; i < cardsRankSortedString.size(); i++){
            straightString += cardsRankSortedString.get(i);
        }
        return straightString;
    }
}

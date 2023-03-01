import java.util.ArrayList;
import java.util.Collections;


public class PokerGameEvaluation {

/*  The evaluation of the poker hands.
    This class is responsible for evaluating the cards passed to this class, determining
    the type of poker.
     Responsible for creating the instance of PokerHand classes (full house class, pair class, etc)
     Responsible for breaking ties and returning the results back to the PokerGame class.

*/

    public PokerHandType checkHands(ArrayList<Card> cards) {
        //returns a pokerHandType: enum: PAIR, FULL_HOUSE, etc

        boolean isPair;
        boolean isTwoPair;
        boolean is3OfKind;
        boolean isStraight;
        boolean isFlush;
        boolean isFullHouse;
        boolean is4OfKind;

        //The cardsRank, cardsSuit store the ranks and suits of the cards to help comparisons to establish poker hand
        //types and later poker hand classes.
        //The tempCardsRank arrayList store the ranks and is sorted so that it helps with the comparisons

        //create the cardsRank and tempCardsRank arrayLists
        ArrayList<Integer> cardsRank;
        cardsRank = createCardsRank(cards);
        ArrayList<Integer> tempRankOrder;
        tempRankOrder = createTempRankOrder(cardsRank);

        ArrayList<String> cardsSuit;
        cardsSuit = new ArrayList<>();

        int x = 0;
        for (Card c : cards) {
            cardsSuit.add(c.getSuit());
            x++;
        }

        //The determination of whether a hand is one of the pokerHandTypes and returns the PokerHandType enum
        is4OfKind = has4ofAKind(cardsRank);

        if (is4OfKind) {
            return PokerHandType.FOUR_OF_A_KIND;
        } else {
            is3OfKind = has3OfAKind(cardsRank);
            if (is3OfKind) {
                isFullHouse = hasFullHouse(cardsRank);
                if (isFullHouse) {
                    return PokerHandType.FULL_HOUSE;
                } else {
                    return PokerHandType.THREE_OF_A_KIND;
                }
            } else {
                isPair = hasPair(cardsRank);
                if (isPair) {
                    isTwoPair = hasTwoPair(cardsRank);
                    if (isTwoPair) {
                        return PokerHandType.TWO_PAIR;
                    } else {
                        return PokerHandType.PAIR;
                    }
                } else {
                    isFlush = hasFlush(cardsSuit);
                    isStraight = hasStraight(tempRankOrder);
                    if (isFlush && isStraight) {
                        return PokerHandType.STRAIGHT_FLUSH;
                    } else {
                        if (isFlush) {
                            return PokerHandType.FLUSH;
                        } else {
                            if (isStraight) {
                                return PokerHandType.STRAIGHT;
                            } else {
                                return PokerHandType.HIGH_CARD;
                            }
                        }
                    }
                }
            }
        }
    }


    private ArrayList<Integer> createCardsRank(ArrayList<Card> cards) {
        //creates an array cardsRank with the cards' ranks
        ArrayList<Integer> cardsRank;
        cardsRank = new ArrayList<>();

        int x = 0;
        for (Card c : cards) {
            cardsRank.add(c.getRank());
            x++;
        }
        return cardsRank;
    }


    private ArrayList<Integer> createTempRankOrder(ArrayList<Integer> cardsRank) {
        //Takes in the arrayList of cardsRank, creates a copy, sorts the copy and returns this sorted copy
        //There needs to be a copy of the ranks, so that way the original arrayList of ranks is not affected.

        ArrayList<Integer> tempCardsRank = new ArrayList<>(cardsRank); //creates a copy of cardsRank.
        Collections.sort(tempCardsRank);

        return tempCardsRank;
    }


    private ArrayList<String> createCardsRankString(ArrayList<Card> cards) {
        //Creates an array with the cards' rank Strings (to be able to represent all cards ranks, even face cards)
        ArrayList<String> cardsRankString;
        cardsRankString = new ArrayList<>();

        int x = 0;
        for (Card c : cards) {
            cardsRankString.add(c.getRankString());
            x++;
        }

        return cardsRankString;
    }


    //The following hasX classes help the above method, checkHands, to determine the type of poker hand
    //Each will return an array of values to create their respective Class pokerHandType Enums
    private boolean hasTwoPair(ArrayList<Integer> cardsRank) {
        boolean isTwoPair = false;
        int firstPair = 0;
        int secondPair = 0;


        //If a card rank appeared two times, then it's a pair
        for (int i = 0; i < cardsRank.size(); i++) {
            if (Collections.frequency(cardsRank, cardsRank.get(i)) == 2) {
                firstPair = cardsRank.get(i);
            }
        }
        //Finds a second pair if the card rank appears twice and is not equal to the first pair
        for (int i = 0; i < cardsRank.size(); i++) {
            if (cardsRank.get(i) != firstPair && Collections.frequency(cardsRank, cardsRank.get(i)) == 2) {
                secondPair = cardsRank.get(i);
            }
        }
        //If found 2 pairs, then this hand has two pairs
        if (firstPair != 0 && secondPair != 0) {
            isTwoPair = true;
        }

        return isTwoPair;
    }


    private boolean hasFullHouse(ArrayList<Integer> cardsRank) {
        boolean isFullHouse = false;
        int threeSpread = 0;
        int pair = 0;

        //Determine the set of 3
        for (int i = 0; i < cardsRank.size(); i++) {
            if (Collections.frequency(cardsRank, cardsRank.get(i)) == 3) {
                threeSpread = cardsRank.get(i);
            }
        }
        //Determine the set of 2
        for (int i = 0; i < cardsRank.size(); i++) {
            if (cardsRank.get(i) != threeSpread && Collections.frequency(cardsRank, cardsRank.get(i)) == 2) {
                pair = cardsRank.get(i);
            }
        }

        if (threeSpread != 0 && pair != 0) {
            isFullHouse = true;
        }
        return isFullHouse;
    }


    private boolean isConsecutiveOrder(ArrayList<Integer> tempRankOrder) {
        //Tells if the deck is made up of consecutive order cards
        //This method uses the sorted copy of the ranks array to help determine the outcome for straights
        boolean isConsecutive = false;

        for (int i = 1; i < tempRankOrder.size(); ++i) {
            if (tempRankOrder.get(i) - tempRankOrder.get(i - 1) != 1) {
                isConsecutive = false;
                break;
            } else {
                isConsecutive = true;
            }
        }
        return isConsecutive;
    }


    private boolean hasPair(ArrayList<Integer> cardsRank) {
        boolean isPair = false;
        int pair = 0;

        for (int i = 0; i < cardsRank.size(); i++) {
            if (Collections.frequency(cardsRank, cardsRank.get(i)) == 2) {
                pair = cardsRank.get(i);
            }
        }
        if (pair != 0) {
            isPair = true;
        }
        return isPair;
    }


    private boolean has3OfAKind(ArrayList<Integer> cardsRank) {
        boolean is3OfAKind = false;

        for (int i = 0; i < cardsRank.size(); i++) {
            if (Collections.frequency(cardsRank, cardsRank.get(i)) == 3) {
                is3OfAKind = true;
            }
        }
        return is3OfAKind;
    }


    private boolean has4ofAKind(ArrayList<Integer> cardsRank) {
        boolean is4OfAKind = false;

        for (int i : cardsRank) {
            if (Collections.frequency(cardsRank, i) == 4) {
                is4OfAKind = true;
            }
        }
        return is4OfAKind;
    }


    private boolean hasStraight(ArrayList<Integer> tempRankOrder) {
        boolean isStraight = false;

        if (isConsecutiveOrder(tempRankOrder)) {
            isStraight = true;
        }
        return isStraight;
    }


    private boolean hasFlush(ArrayList<String> cardsSuit) {
        boolean isFlush = false;

        for (String s : cardsSuit) {
            if (Collections.frequency(cardsSuit, s) == cardsSuit.size()) { //If all cards are the same suit
                isFlush = true;
            }
        }
        return isFlush;
    }


    //Base on the type of poker hand, the instance of the respective Class will be created
    public PokerHand createThePokerHand(ArrayList<Card> cards, PokerHandType pokerHandType){
        //arrayList of ranks
        ArrayList<Integer> cardsRank;
        //sorted rank list
        ArrayList<Integer> tempRankOrder;
        //rank string list
        ArrayList<String> cardsRankString;

        cardsRank = createCardsRank(cards);
        tempRankOrder = createTempRankOrder(cardsRank);
        cardsRankString = createCardsRankString(cards);

        //PokerHand that will be return after the respective PokerHand Class is created based on the PokerHandType Enum
        PokerHand basePokerHand = new PokerHand(pokerHandType);

        switch (pokerHandType){
            case HIGH_CARD:
                basePokerHand = createHighCardHand(cards, tempRankOrder, cardsRank, pokerHandType, cardsRankString);
                break;
            case PAIR:
                basePokerHand = createPairHand(cards, tempRankOrder, cardsRank, pokerHandType, cardsRankString);
                break;
            case TWO_PAIR:
                basePokerHand = createTwoPairHand(cards, tempRankOrder, cardsRank, pokerHandType, cardsRankString);
                break;
            case THREE_OF_A_KIND:
                basePokerHand = createThreeOfAKindHand(cards, tempRankOrder, cardsRank, pokerHandType, cardsRankString);
                break;
            case STRAIGHT:
                basePokerHand = createStraightHand(cards, tempRankOrder, cardsRank, pokerHandType, cardsRankString);
                break;
            case FLUSH:
                basePokerHand = createFlushHand(cards, tempRankOrder, cardsRank, pokerHandType, cardsRankString);
                break;
            case FULL_HOUSE:
                basePokerHand = createFullHouseHand(cards, tempRankOrder, cardsRank, pokerHandType, cardsRankString);
                break;
            case FOUR_OF_A_KIND:
                basePokerHand = createFourOfAKindHand(cards, tempRankOrder, cardsRank, pokerHandType, cardsRankString);
                break;
            case STRAIGHT_FLUSH:
                basePokerHand = createStraightFlush(cards, tempRankOrder, cardsRank, pokerHandType, cardsRankString);
                break;
        }

        return basePokerHand;
    }


    //The following createXHand methods create instances of the pokerHandX classes
    private PokerHand createHighCardHand(ArrayList<Card> cards, ArrayList<Integer> tempRankOrder,
                                    ArrayList<Integer> cardsRank, PokerHandType pokerHandType,
                                         ArrayList<String> cardsRankString) {
        //Creates an instance of HighCard class

        int highValue;          //get high value
        int indexOfHighValue;   //get index of high value
        String highValueString;          //use index to get the card rankString

        highValue = tempRankOrder.get(tempRankOrder.size() - 1);
        indexOfHighValue = cardsRank.indexOf(highValue);
        //highCard = cards.get(indexOfHighValue);
        highValueString = cards.get(indexOfHighValue).getRankString();
        // this should be the above highValue = cards.get(indexOfHighValue).getRank();

        return new HighCard(pokerHandType, cardsRank, cardsRankString, tempRankOrder, highValueString, highValue);
    }


    PokerHand createPairHand(ArrayList<Card> cards, ArrayList<Integer> tempRankOrder,
                             ArrayList<Integer> cardsRank, PokerHandType pokerHandType,
                             ArrayList<String> cardsRankString) {

        //Creates an instance of Pair class
        int pairValue = 0;
        int indexOfPair;    //use pair value to get the index
        String pairValueString;      //use the index to get the card

        for (int i = 0; i < cardsRank.size(); i++) {
            if (Collections.frequency(cardsRank, cardsRank.get(i)) == 2) {
                pairValue = cardsRank.get(i);
            }
        }
        indexOfPair = cardsRank.indexOf(pairValue);
        pairValueString = cards.get(indexOfPair).getRankString();
        return new Pair(pokerHandType, cardsRank, cardsRankString,tempRankOrder, pairValueString, pairValue);
    }


    private PokerHand createTwoPairHand(ArrayList<Card> cards, ArrayList<Integer> tempRankOrder,
                                        ArrayList<Integer> cardsRank, PokerHandType pokerHandType,
                                        ArrayList<String> cardsRankString) {
        int firstPair = 0;
        String firstPairString;
        int indexForPair1;

        int secondPair = 0;
        String secondPairString;
        int indexForPair2;

        int lastCard = 0;
        String lastCardString;
        int indexForLastCard;

        //Get the first pair
        for (int i = 0; i < cardsRank.size(); i++) {
            if (Collections.frequency(cardsRank, cardsRank.get(i)) == 2) {
                firstPair = cardsRank.get(i);
            }
        }
        //Get the second pair
        for (int i = 0; i < cardsRank.size(); i++) {
            if (cardsRank.get(i) != firstPair && Collections.frequency(cardsRank, cardsRank.get(i)) == 2) {
                secondPair = cardsRank.get(i);
            }
        }
        //Get the last card
        for (int i = 0; i < cardsRank.size(); i++) {
            if (cardsRank.get(i) != firstPair &&
                    cardsRank.get(i) != secondPair){
                lastCard = cardsRank.get(i);
            }
        }

        indexForPair1 = cardsRank.indexOf(firstPair);
        indexForPair2 = cardsRank.indexOf(secondPair);
        indexForLastCard = cardsRank.indexOf(lastCard);

        firstPairString = cards.get(indexForPair1).getRankString();
        secondPairString = cards.get(indexForPair2).getRankString();
        lastCardString = cards.get(indexForLastCard).getRankString();

        return new TwoPair(pokerHandType, cardsRank, cardsRankString, tempRankOrder, firstPair, firstPairString,
                secondPair, secondPairString, lastCard, lastCardString);
    }


    private PokerHand createThreeOfAKindHand(ArrayList<Card> cards, ArrayList<Integer> tempRankOrder,
                                             ArrayList<Integer> cardsRank, PokerHandType pokerHandType,
                                             ArrayList<String> cardsRankString) {
        //creates a 3ofAKind instance
        int threeSpread = 0;
        int indexOfThreeSpread;
        String threeSpreadString;

        for (int i = 0; i < cardsRank.size(); i++) {
            if (Collections.frequency(cardsRank, cardsRank.get(i)) == 3) {
                threeSpread = cardsRank.get(i);
            }
        }
        indexOfThreeSpread = cardsRank.indexOf(threeSpread);
        threeSpreadString = cards.get(indexOfThreeSpread).getRankString();

        return new ThreeOfAKind(pokerHandType, cardsRank, cardsRankString, tempRankOrder,
                threeSpread, threeSpreadString);
    }


    private PokerHand createStraightHand(ArrayList<Card> cards, ArrayList<Integer> tempRankOrder,
                                         ArrayList<Integer> cardsRank, PokerHandType pokerHandType,
                                         ArrayList<String> cardsRankString) {
        //Create Straight instance

        ArrayList<String> straightCardsSorted = new ArrayList<>();
        ArrayList<Integer> tempIndexesOrderOfValue = new ArrayList<>();

        for (int i = 0; i < cards.size(); i++){
            tempIndexesOrderOfValue.add(cardsRank.indexOf(tempRankOrder.get(i))); //get values from tempRankOrder
        }
        //now the tempIndexesOrderOfValue has the indexes of original rank order, but in order of low to high
        //Use the tempIndexesOrderOfValue to get the cards' rankStrings
        for (int i = 0; i < cards.size(); i++) {
            straightCardsSorted.add(0, cards.get(tempIndexesOrderOfValue.get(i)).getRankString());
        }

        return new Straight(pokerHandType, cardsRank, cardsRankString, tempRankOrder, straightCardsSorted);
        }


    private PokerHand createFlushHand(ArrayList<Card> cards, ArrayList<Integer> tempRankOrder,
                                      ArrayList<Integer> cardsRank, PokerHandType pokerHandType,
                                      ArrayList<String> cardsRankString) {
        //Create flush instance
        String flushSuitString;
        ArrayList<String> flushCardsSorted = new ArrayList<>();
        ArrayList<Integer> tempIndexesOrderOfValue = new ArrayList<>();

        for (int i = 0; i < cards.size(); i++){
            tempIndexesOrderOfValue.add(cardsRank.indexOf(tempRankOrder.get(i))); //get values from tempRankOrder
        }
        //now the tempIndexesOrderOfValue has the indexes of original rank order, but in order of low to high
        //Use the tempIndexesOrderOfValue to get the cards' string values and store them in the
        // flushCardsSorted arrayList
        for (int i = 0; i < cards.size(); i++) {
            flushCardsSorted.add(0, cards.get(tempIndexesOrderOfValue.get(i)).getRankString());
        }
        flushSuitString = cards.get(0).getSuit(); //All cards will share the same suit.

        return new Flush(pokerHandType, cardsRank, cardsRankString, tempRankOrder, flushSuitString, flushCardsSorted);
    }


    private PokerHand createFullHouseHand(ArrayList<Card> cards, ArrayList<Integer> tempRankOrder,
                                          ArrayList<Integer> cardsRank, PokerHandType pokerHandType,
                                          ArrayList<String> cardsRankString) {
        //Create Full House instance

        int threeSpread = 0;
        String threeSpreadString;
        int indexForThreeSpread;

        int pair = 0;
        String pairString;
        int indexForPair;

        //Get the threeSpread
        for (int i = 0; i < cardsRank.size(); i++) {
            if (Collections.frequency(cardsRank, cardsRank.get(i)) == 3) {
                threeSpread = cardsRank.get(i);
            }
        }
        //Get the pair
        for (int i = 0; i < cardsRank.size(); i++) {
            if (cardsRank.get(i) != threeSpread && Collections.frequency(cardsRank, cardsRank.get(i)) == 2) {
                pair = cardsRank.get(i);
            }
        }
        indexForThreeSpread = cardsRank.indexOf(threeSpread);
        indexForPair = cardsRank.indexOf(pair);

        threeSpreadString = cards.get(indexForThreeSpread).getRankString();
        pairString = cards.get(indexForPair).getRankString();

        return new FullHouse(pokerHandType, cardsRank, cardsRankString, tempRankOrder,
                threeSpread, threeSpreadString, pair, pairString);
    }


    private PokerHand createFourOfAKindHand(ArrayList<Card> cards, ArrayList<Integer> tempRankOrder,
                                            ArrayList<Integer> cardsRank, PokerHandType pokerHandType,
                                            ArrayList<String> cardsRankString) {
        //Create 4 of a kind instance

        int fourSpread = 0;
        int indexOfFourSpread;
        String fourSpreadString;

        for (int i = 0; i < cardsRank.size(); i++) {
            if (Collections.frequency(cardsRank, cardsRank.get(i)) == 4) {
                fourSpread = cardsRank.get(i);
            }
        }
        indexOfFourSpread = cardsRank.indexOf(fourSpread);
        fourSpreadString = cards.get(indexOfFourSpread).getRankString();

        return new FourOfAKind(pokerHandType, cardsRank, cardsRankString, tempRankOrder, fourSpread, fourSpreadString);
    }


    private PokerHand createStraightFlush(ArrayList<Card> cards, ArrayList<Integer> tempRankOrder,
                                          ArrayList<Integer> cardsRank, PokerHandType pokerHandType,
                                          ArrayList<String> cardsRankString) {
        //Create Straight Flush of a kind instance
        String flushStraightSuitString;
        ArrayList<String> flushCardsSorted = new ArrayList<>();
        ArrayList<Integer> tempIndexesOrderOfValue = new ArrayList<>();

        for (int i = 0; i < cards.size(); i++){
            tempIndexesOrderOfValue.add(cardsRank.indexOf(tempRankOrder.get(i))); //get values from tempRankOrder
        }
        //now the tempIndexesOrderOfValue has the indexes of original rank order, but in order of low to high
        //Use the tempIndexesOrderOfValue to get the cards
        for (int i = 0; i < cards.size(); i++) {
            flushCardsSorted.add(0, cards.get(tempIndexesOrderOfValue.get(i)).getRankString());
        }
        flushStraightSuitString = cards.get(0).getSuit(); //All cards will share the same suit.

        return new StraightFlush(pokerHandType, cardsRank, cardsRankString, tempRankOrder,
                flushStraightSuitString, flushCardsSorted);
    }


    //The tieBreaker calls methods based on the pokerHandType to break ties between the different pokerHandTypes
    public String tieBreaker(Player player1, Player player2, ArrayList<Card> hand1Cards, ArrayList<Card> hand2Cards,
                             PokerHandType player1PokerHandType, PokerHandType player2PokerHandType) {
        //pass in one of the PokerHands and get the PokerHandType for the switch
        //use the switch to call respective tieBreaker methods
        //returns the winning Message
        String winningMessage = "";



        switch (player1PokerHandType){
            case HIGH_CARD:
                HighCard highCardHand1 = (HighCard) createThePokerHand(hand1Cards, player1PokerHandType);
                HighCard highCardHand2 = (HighCard) createThePokerHand(hand2Cards, player2PokerHandType);
                winningMessage = highCardTieBreaker(highCardHand1, highCardHand2, player1, player2);
                break;
            case PAIR:
                Pair pairHand1 = (Pair) createThePokerHand(hand1Cards, player1PokerHandType);
                Pair pairHand2 = (Pair) createThePokerHand(hand2Cards, player2PokerHandType);
                winningMessage = pairTieBreaker(pairHand1, pairHand2, player1, player2);
                break;
            case TWO_PAIR:
                TwoPair twoPairHand1 = (TwoPair) createThePokerHand(hand1Cards, player1PokerHandType);
                TwoPair twoPairHand2 = (TwoPair) createThePokerHand(hand2Cards, player2PokerHandType);
                winningMessage = twoPairTieBreaker(twoPairHand1, twoPairHand2, player1, player2);
                break;
            case THREE_OF_A_KIND:
                ThreeOfAKind threeOfAKindHand1 = (ThreeOfAKind) createThePokerHand(hand1Cards, player1PokerHandType);
                ThreeOfAKind threeOfAKindHand2 = (ThreeOfAKind) createThePokerHand(hand2Cards, player2PokerHandType);
                winningMessage = threeOfAKindTieBreaker(threeOfAKindHand1, threeOfAKindHand2, player1, player2);
                break;
            case STRAIGHT:
                Straight straightHand1 = (Straight) createThePokerHand(hand1Cards, player1PokerHandType);
                Straight StraightHand2 = (Straight) createThePokerHand(hand2Cards, player2PokerHandType);
                winningMessage = straightTieBreaker(straightHand1, StraightHand2, player1, player2);
                break;
            case FLUSH:
                Flush flushHand1 = (Flush) createThePokerHand(hand1Cards, player1PokerHandType);
                Flush flushHand2 = (Flush) createThePokerHand(hand2Cards, player2PokerHandType);
                winningMessage = flushTieBreaker(flushHand1, flushHand2, player1, player2);
                break;
            case FULL_HOUSE:
                FullHouse fullHouseHand1 = (FullHouse) createThePokerHand(hand1Cards, player1PokerHandType);
                FullHouse fullHouseHand2 = (FullHouse) createThePokerHand(hand2Cards, player2PokerHandType);
                winningMessage = fullHouseTieBreaker(fullHouseHand1, fullHouseHand2, player1, player2);
                break;
            case FOUR_OF_A_KIND:
                FourOfAKind fourOfAKindHand1 = (FourOfAKind) createThePokerHand(hand1Cards, player1PokerHandType);
                FourOfAKind fourOfAKindHand2 = (FourOfAKind) createThePokerHand(hand2Cards, player2PokerHandType);
                winningMessage = fourOfAKindTieBreaker(fourOfAKindHand1, fourOfAKindHand2, player1, player2);
                break;
            case STRAIGHT_FLUSH:
                StraightFlush straightFlushHand1 = (StraightFlush) createThePokerHand(hand1Cards, player1PokerHandType);
                StraightFlush straightFlushHand2 = (StraightFlush) createThePokerHand(hand2Cards, player2PokerHandType);
                winningMessage = StraightFlushTieBreaker(straightFlushHand1, straightFlushHand2, player1, player2);
                break;
        }

        return winningMessage;
    }


    private String highCardTieBreaker(HighCard highCardTieBreakerHand1, HighCard highCardTieBreakerHand2,
                                      Player player1, Player player2) {
        boolean isTie = false;
        boolean isTieBroken = false;
        int highCard;
        String winningMessage = "";

        //The for loop will continue to compare the cards in descending order until a difference is found. If all
        //cards are equal, then this is a tie
        for (int i = highCardTieBreakerHand1.tempCardsRankSorted.size() - 1; i > 0 || !isTieBroken; i--) {
            if (highCardTieBreakerHand1.tempCardsRankSorted.get(i) >
                    (highCardTieBreakerHand2.tempCardsRankSorted.get(i))) {
                isTieBroken = true;
                highCard = highCardTieBreakerHand1.tempCardsRankSorted.get(i);
                winningMessage = highCardTieBreakerWinMessage(player1.getName(), highCardTieBreakerHand1, highCard);
            break;
            }
            if (!isTieBroken && highCardTieBreakerHand1.tempCardsRankSorted.get(i) <
                    (highCardTieBreakerHand2.tempCardsRankSorted.get(i))) {
                isTieBroken = true;
                highCard = (highCardTieBreakerHand2.tempCardsRankSorted.get(i));
                winningMessage = highCardTieBreakerWinMessage(player2.getName(), highCardTieBreakerHand2, highCard);
            break;
            }
            if (i == 0){
                isTie = true;
                isTieBroken = true;
            }
        }
        if (isTie) {
            return "Tie";
        } else {

            return winningMessage;
        }
    }

    private String highCardTieBreakerWinMessage(String name, HighCard pokerHand, int highCard) {
        int highCardIndex;
        highCardIndex = pokerHand.cardsRank.indexOf(highCard);
        String highCardString = pokerHand.cardsRankString.get(highCardIndex);
        return  name + " wins with - " + pokerHand.getPokerHandType().getPokerHandName() + " of " + highCardString;
    }

    private String pairTieBreaker(Pair pairHand1, Pair pairHand2, Player player1, Player player2) {

        boolean isTie = false;
        boolean isTieBroken = false;
        int highCard = 0;
        String winningMessage = "";


        if (pairHand1.getPairValue() > pairHand2.getPairValue()) {
            winningMessage = player1.getName() + " wins with - " + pairHand1.toString();
        } else {
            if (pairHand1.getPairValue() < pairHand2.getPairValue()) {
                winningMessage = player2.getName() + " wins with - " + pairHand2.toString();
            } else {
                //If the pairs are of equal value: both pairs of 2, what is the high card of the remaining cards
                //will need the sorted ranks arrayList
                for (int i = pairHand1.cardsRank.size() - 1; i > 0 || !isTieBroken; i--) {
                    if (pairHand1.cardsRank.get(i) > (pairHand2.cardsRank.get(i))
                            && pairHand1.cardsRank.get(i) != pairHand1.getPairValue()) {
                        //Make sure it's not equal to the pair
                        isTieBroken = true;
                        highCard = pairHand1.cardsRank.get(i);
                        winningMessage = pairTieBreakerWinMessage(player1.getName(), pairHand1, highCard);
                    }
                    if (!isTieBroken && pairHand1.cardsRank.get(i) < (pairHand2.cardsRank.get(i))
                            && pairHand1.cardsRank.get(i) != pairHand1.getPairValue()) {
                        highCard = (pairHand2.cardsRank.get(i));
                        winningMessage = pairTieBreakerWinMessage(player2.getName(), pairHand2, highCard);
                    }
                    if(i == 0 && !isTieBroken){
                        isTie = true;
                        isTieBroken = true;
                    }
                }
            }
        }
        if (isTie) {
            return "Tie";
        } else {
            return winningMessage;
        }
    }


    private String pairTieBreakerWinMessage(String name, Pair pokerHand, int highCard) {
        int highCardIndex;
        highCardIndex = pokerHand.cardsRank.indexOf(highCard);
        String highCardString = pokerHand.cardsRankString.get(highCardIndex);
        return  name + " wins with - " + pokerHand.toString() + " with " + highCardString + " high";
    }


    private String twoPairTieBreaker(TwoPair twoPairHand1, TwoPair twoPairHand2, Player player1, Player player2) {
        boolean isTie = false;
        boolean isTieBroken = false;

        String winningMessage = "";

        int highPairOfHand1;
        int highPairOfHand2;
        int lowPairOfHand1;
        int lowPairOfHand2;

        //get the higher pair
        highPairOfHand1 = Math.max(twoPairHand1.getPairValue(), twoPairHand1.getPair2Value());
        highPairOfHand2 = Math.max(twoPairHand2.getPairValue(), twoPairHand2.getPair2Value());

        //get the lower pair
        lowPairOfHand1 = Math.min(twoPairHand1.getPairValue(), twoPairHand1.getPair2Value());
        lowPairOfHand2 = Math.min(twoPairHand2.getPairValue(), twoPairHand2.getPair2Value());

        //get the last card: hand 1


        //compare high pairs first
        if (highPairOfHand1 > highPairOfHand2) {
            isTieBroken = true;
            winningMessage = player1.getName() + " wins with - " + twoPairHand1.toString();
        }
        if (highPairOfHand1 < highPairOfHand2) {
            isTieBroken = true;
            winningMessage = player2.getName() + " wins with - " + twoPairHand2.toString();
        }
        //If the high pairs match, compare the lower pair
        if (!isTieBroken) {
            if (lowPairOfHand1 > lowPairOfHand2) {
                isTieBroken = true;
                winningMessage = player1.getName() + " wins with - " + twoPairHand1.toString();
            }
            if (lowPairOfHand1 < lowPairOfHand2) {
                isTieBroken = true;
                winningMessage = player2.getName() + " wins with - " + twoPairHand2.toString();
            }
        }
        //If the lower pairs match as well, then the victory comes down to the last card.
        if (!isTieBroken) {
            if (twoPairHand1.getLastCardValue() > twoPairHand2.getLastCardValue()) {
                isTieBroken = true;
                winningMessage = twoPairTieBreakerWinMessage(player1.getName(), twoPairHand1);
            }
            if (twoPairHand1.getLastCardValue() < twoPairHand2.getLastCardValue()) {
                isTieBroken = true;
                winningMessage = twoPairTieBreakerWinMessage(player2.getName(), twoPairHand2);
            }
        }

        if (!isTieBroken){
            isTie = true;
            isTieBroken = true;
        }
        if (isTie) {
            return "Tie";
        } else {
            return winningMessage;
        }
    }


    private String twoPairTieBreakerWinMessage(String name, TwoPair pokerHand) {
        return  name + " wins with - " + pokerHand.toString() + " with " + pokerHand.getLastCardValueString()
                + " high";
    }


    private String threeOfAKindTieBreaker(ThreeOfAKind threeOfAKindHand1, ThreeOfAKind threeOfAKindHand2,
                                          Player player1, Player player2) {
        /*
         The ruling for a 3 of a kind is the higher of the 3 spread. If both hands have a three of a kind, it is
         the hand with the higher 3 spread that wins.
         */

        String winningResults = "";

        //compare the 3 spread
        if (threeOfAKindHand1.getThreeSpreadValue() > threeOfAKindHand2.getThreeSpreadValue()) {
            winningResults = threeOfAKindTieBreakerWinMessage(player1.getName(), threeOfAKindHand1);
        } else {
            if (threeOfAKindHand1.getThreeSpreadValue() < threeOfAKindHand2.getThreeSpreadValue()) {
                winningResults = threeOfAKindTieBreakerWinMessage(player2.getName(), threeOfAKindHand2);
            }
        }
        return winningResults;
    }


    private String threeOfAKindTieBreakerWinMessage(String name, ThreeOfAKind pokerHand) {
        return  name + " wins with - " + pokerHand.toString();
    }


    private String straightTieBreaker(Straight straightHand1, Straight straightHand2,
                                   Player player1, Player player2) {
        boolean isTie = false;
        boolean isTieBroken = false;
        int highCard;
        String winningMessage = "";

        //The for loop will continue to compare the cards in descending order until a difference is found. If all
        //cards are equal, then this is a tie
        for (int i = straightHand1.tempCardsRankSorted.size() - 1; i > 0 || !isTieBroken; i--) {
            if (straightHand1.tempCardsRankSorted.get(i) >
                    (straightHand2.tempCardsRankSorted.get(i))) {
                isTieBroken = true;
                highCard = straightHand1.tempCardsRankSorted.get(i);
                winningMessage = straightTieBreakerWinMessage(player1.getName(), straightHand1, highCard);
                break;
            }
            if (!isTieBroken && straightHand1.tempCardsRankSorted.get(i) <
                    (straightHand2.tempCardsRankSorted.get(i))) {
                isTieBroken = true;
                highCard = (straightHand2.tempCardsRankSorted.get(i));
                winningMessage = straightTieBreakerWinMessage(player2.getName(), straightHand2, highCard);
                break;
            }
            if (i == 0){
                isTie = true;
                isTieBroken = true;
            }
        }
        if (isTie) {
            return "Tie";
        } else {

            return winningMessage;
        }
    }

    private String straightTieBreakerWinMessage(String name, Straight pokerHand, int highCard) {
        int highCardIndex;
        highCardIndex = pokerHand.cardsRank.indexOf(highCard);
        String highCardString = pokerHand.cardsRankString.get(highCardIndex);

        return  name + " wins with - " + pokerHand.getPokerHandType().getPokerHandName() + " of " + pokerHand.toString()
                + " with " + highCardString + " high";
    }


    private String fullHouseTieBreaker(FullHouse fullHouseHand1, FullHouse fullHouseHand2,
                                       Player player1, Player player2) {
        //For Full House, the winning condition is that of the three spread pair.
        String winingResults = "";

        //compare the 3 spread
        if (fullHouseHand1.getThreeSpreadValue() > fullHouseHand2.getThreeSpreadValue()) {
            winingResults =  fullHouseWinMessage(player1.getName(), fullHouseHand1);
        } else {
            if (fullHouseHand1.getThreeSpreadValue() < fullHouseHand2.getThreeSpreadValue()) {
                winingResults = fullHouseWinMessage(player2.getName(), fullHouseHand2);
            }
        }
        return winingResults;
    }


    private String fullHouseWinMessage(String name, FullHouse fullHouseHand) {
        return name + " wins with - " + fullHouseHand.toString();
    }

    private String flushTieBreaker(Flush flushHand1, Flush flushHand2,
                                   Player player1, Player player2) {
        boolean isTie = false;
        boolean isTieBroken = false;
        int highCard;
        String winningMessage = "";

        //The for loop will continue to compare the cards in descending order until a difference is found. If all
        //cards are equal, then this is a tie
        for (int i = flushHand1.tempCardsRankSorted.size() - 1; i > 0 || !isTieBroken; i--) {
            if (flushHand1.tempCardsRankSorted.get(i) >
                    (flushHand2.tempCardsRankSorted.get(i))) {
                isTieBroken = true;
                highCard = flushHand1.tempCardsRankSorted.get(i);
                winningMessage = flushTieBreakerWinMessage(player1.getName(), flushHand1, highCard);
                break;
            }
            if (!isTieBroken && flushHand1.tempCardsRankSorted.get(i) <
                    (flushHand2.tempCardsRankSorted.get(i))) {
                isTieBroken = true;
                highCard = (flushHand2.tempCardsRankSorted.get(i));
                winningMessage = flushTieBreakerWinMessage(player2.getName(), flushHand2, highCard);
                break;
            }
            if (i == 0){
                isTie = true;
                isTieBroken = true;
            }
        }
        if (isTie) {
            return "Tie";
        } else {

            return winningMessage;
        }
    }

    private String flushTieBreakerWinMessage(String name, Flush pokerHand, int highCard) {
        int highCardIndex;
        highCardIndex = pokerHand.cardsRank.indexOf(highCard);
        String highCardString = pokerHand.cardsRankString.get(highCardIndex);

        return  name + " wins with - " + pokerHand.toString()
                + " with " + highCardString + " high";
    }


    private String fourOfAKindTieBreaker(FourOfAKind fourOfAKindHand1, FourOfAKind fourOfAKindHand2,
                                         Player player1, Player player2) {
        // The ruling for a 4 of a kind is the higher of the 4 spread
        String winningPlayer = "";

        //compare the 4 spread
        if (fourOfAKindHand1.getFourSpreadValue() > fourOfAKindHand2.getFourSpreadValue()) {
            winningPlayer = fourOfAKindWinMessage(player1.getName(), fourOfAKindHand1);
        } else {
            if (fourOfAKindHand1.getFourSpreadValue() < fourOfAKindHand2.getFourSpreadValue()) {
                winningPlayer = fourOfAKindWinMessage(player2.getName(), fourOfAKindHand2);
            }
        }


        return winningPlayer;
    }

    private String fourOfAKindWinMessage(String name, FourOfAKind fourOfAKindHand) {
        return name + " wins with - " + fourOfAKindHand.toString();
    }


    private String StraightFlushTieBreaker(StraightFlush straightFlushHand1, StraightFlush straightFlushHand2,
                                      Player player1, Player player2) {
        boolean isTie = false;
        boolean isTieBroken = false;
        int highCard;
        String winningMessage = "";

        //The for loop will continue to compare the cards in descending order until a difference is found. If all
        //cards are equal, then this is a tie
        for (int i = straightFlushHand1.tempCardsRankSorted.size() - 1; i > 0 || !isTieBroken; i--) {
            if (straightFlushHand1.tempCardsRankSorted.get(i) >
                    (straightFlushHand2.tempCardsRankSorted.get(i))) {
                isTieBroken = true;
                highCard = straightFlushHand1.tempCardsRankSorted.get(i);
                winningMessage = StraightFlushTieBreakerWinMessage(player1.getName(), straightFlushHand1, highCard);
                break;
            }
            if (!isTieBroken && straightFlushHand1.tempCardsRankSorted.get(i) <
                    (straightFlushHand2.tempCardsRankSorted.get(i))) {
                isTieBroken = true;
                highCard = (straightFlushHand2.tempCardsRankSorted.get(i));
                winningMessage = StraightFlushTieBreakerWinMessage(player2.getName(), straightFlushHand2, highCard);
                break;
            }
            if (i == 0){
                isTie = true;
                isTieBroken = true;
            }
        }
        if (isTie) {
            return "Tie";
        } else {

            return winningMessage;
        }
    }

    private String StraightFlushTieBreakerWinMessage(String name, StraightFlush pokerHand, int highCard) {
        int highCardIndex;
        highCardIndex = pokerHand.cardsRank.indexOf(highCard);
        String highCardString = pokerHand.cardsRankString.get(highCardIndex);

        return  name + " wins with - " + pokerHand.toString() +
                " with " + highCardString + " high";
    }

}

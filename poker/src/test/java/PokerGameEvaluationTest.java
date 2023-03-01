import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class PokerGameEvaluationTest {
    //the following tests the accuracy of determining the different types of poker hands

    @Test
    void checkHandsForHighCard() {
        /*Test for High Card */
        Card card1 = new Card(Rank.TWO, Suit.HEARTS);
        Card card2 = new Card(Rank.FIVE, Suit.HEARTS);
        Card card3 = new Card(Rank.TEN, Suit.SPADES);
        Card card4 = new Card(Rank.SEVEN, Suit.CLUBS);
        Card card5 = new Card(Rank.QUEEN, Suit.DIAMONDS);

        ArrayList<Card> cards = new ArrayList<>();
        Collections.addAll(cards, card1, card2, card3, card4, card5);

        PokerGameEvaluation Eval = new PokerGameEvaluation();

        assertEquals(PokerHandType.HIGH_CARD, Eval.checkHands(cards));
    }

    @Test
    void checkHandsForPair() {
        /*Test for Pair */
        Card card1 = new Card(Rank.TWO, Suit.HEARTS);
        Card card2 = new Card(Rank.TWO, Suit.CLUBS);
        Card card3 = new Card(Rank.TEN, Suit.SPADES);
        Card card4 = new Card(Rank.SEVEN, Suit.CLUBS);
        Card card5 = new Card(Rank.QUEEN, Suit.DIAMONDS);

        ArrayList<Card> cards = new ArrayList<>();
        Collections.addAll(cards, card1, card2, card3, card4, card5);

        PokerGameEvaluation Eval = new PokerGameEvaluation();

        assertEquals(PokerHandType.PAIR, Eval.checkHands(cards));
    }

    @Test
    void checkHandsForThreeOfAKind() {
        /*Test for 3 of a kind */
        Card card1 = new Card(Rank.TWO, Suit.HEARTS);
        Card card2 = new Card(Rank.TWO, Suit.DIAMONDS);
        Card card3 = new Card(Rank.TWO, Suit.SPADES);
        Card card4 = new Card(Rank.KING, Suit.CLUBS);
        Card card5 = new Card(Rank.QUEEN, Suit.DIAMONDS);

        ArrayList<Card> cards = new ArrayList<>();
        Collections.addAll(cards, card1, card2, card3, card4, card5);

        PokerGameEvaluation Eval = new PokerGameEvaluation();

        assertEquals(PokerHandType.THREE_OF_A_KIND, Eval.checkHands(cards));
    }

    @Test
    void checkHandsForFourOfAKind() {
        /*Test for 4 of a kind */
        Card card1 = new Card(Rank.TWO, Suit.HEARTS);
        Card card2 = new Card(Rank.TWO, Suit.DIAMONDS);
        Card card3 = new Card(Rank.TWO, Suit.SPADES);
        Card card4 = new Card(Rank.TWO, Suit.CLUBS);
        Card card5 = new Card(Rank.QUEEN, Suit.DIAMONDS);

        ArrayList<Card> cards = new ArrayList<>();
        Collections.addAll(cards, card1, card2, card3, card4, card5);

        PokerGameEvaluation Eval = new PokerGameEvaluation();

        assertEquals(PokerHandType.FOUR_OF_A_KIND, Eval.checkHands(cards));
    }

    @Test
    void checkHandsForTwoPair() {
        /*Test for 2 Pair */
        Card card1 = new Card(Rank.TWO, Suit.HEARTS);
        Card card2 = new Card(Rank.TWO, Suit.CLUBS);
        Card card3 = new Card(Rank.TEN, Suit.SPADES);
        Card card4 = new Card(Rank.TEN, Suit.CLUBS);
        Card card5 = new Card(Rank.QUEEN, Suit.DIAMONDS);

        ArrayList<Card> cards = new ArrayList<>();
        Collections.addAll(cards, card1, card2, card3, card4, card5);

        PokerGameEvaluation Eval = new PokerGameEvaluation();

        assertEquals(PokerHandType.TWO_PAIR, Eval.checkHands(cards));
    }

    @Test
    void checkHandsForStraight() {
        /*Test for Straight */
        Card card1 = new Card(Rank.TWO, Suit.HEARTS);
        Card card2 = new Card(Rank.THREE, Suit.HEARTS);
        Card card3 = new Card(Rank.FOUR, Suit.SPADES);
        Card card4 = new Card(Rank.FIVE, Suit.CLUBS);
        Card card5 = new Card(Rank.SIX, Suit.DIAMONDS);

        ArrayList<Card> cards = new ArrayList<>();
        Collections.addAll(cards, card1, card2, card3, card4, card5);

        PokerGameEvaluation Eval = new PokerGameEvaluation();

        assertEquals(PokerHandType.STRAIGHT, Eval.checkHands(cards));
    }


    @Test
    void checkHandsForFlush() {
        /*Test for flush */
        Card card1 = new Card(Rank.TWO, Suit.HEARTS);
        Card card2 = new Card(Rank.ACE, Suit.HEARTS);
        Card card3 = new Card(Rank.TEN, Suit.HEARTS);
        Card card4 = new Card(Rank.SEVEN, Suit.HEARTS);
        Card card5 = new Card(Rank.QUEEN, Suit.HEARTS);

        ArrayList<Card> cards = new ArrayList<>();
        Collections.addAll(cards, card1, card2, card3, card4, card5);
        PokerGameEvaluation Eval = new PokerGameEvaluation();

        assertEquals(PokerHandType.FLUSH, Eval.checkHands(cards));
    }

    @Test
    void checkHandsForFullHouse() {
        /*Test for full house */
        Card card1 = new Card(Rank.TWO, Suit.HEARTS);
        Card card2 = new Card(Rank.TWO, Suit.DIAMONDS);
        Card card3 = new Card(Rank.TWO, Suit.SPADES);
        Card card4 = new Card(Rank.KING, Suit.CLUBS);
        Card card5 = new Card(Rank.KING, Suit.DIAMONDS);

        ArrayList<Card> cards = new ArrayList<>();
        Collections.addAll(cards, card1, card2, card3, card4, card5);

        PokerGameEvaluation Eval = new PokerGameEvaluation();

        assertEquals(PokerHandType.FULL_HOUSE, Eval.checkHands(cards));
    }


    @Test
    void checkHandsForStraightFlush() {
        /*Test for Straight */
        Card card1 = new Card(Rank.TEN, Suit.CLUBS);
        Card card2 = new Card(Rank.JACK, Suit.CLUBS);
        Card card3 = new Card(Rank.QUEEN, Suit.CLUBS);
        Card card4 = new Card(Rank.KING, Suit.CLUBS);
        Card card5 = new Card(Rank.ACE, Suit.CLUBS);

        ArrayList<Card> cards = new ArrayList<>();
        Collections.addAll(cards, card1, card2, card3, card4, card5);

        PokerGameEvaluation Eval = new PokerGameEvaluation();

        assertEquals(PokerHandType.STRAIGHT_FLUSH, Eval.checkHands(cards));
    }


    //Testing tie breaker results
    @Test
    void tieBreakerForHighCardWin1() {
        //Show the results when both hands have high cards, and the tie is broken by a high card victory
        //The victor goes to high card of Ace

        Card card1 = new Card(Rank.ACE, Suit.CLUBS);
        Card card2 = new Card(Rank.KING, Suit.DIAMONDS);
        Card card3 = new Card(Rank.JACK, Suit.DIAMONDS);
        Card card4 = new Card(Rank.SIX, Suit.SPADES);
        Card card5 = new Card(Rank.FIVE, Suit.HEARTS);

        ArrayList<Card> cardsHand1 = new ArrayList<>();
        Collections.addAll(cardsHand1, card1, card2, card3, card4, card5);

        Card card6 = new Card(Rank.THREE, Suit.CLUBS);
        Card card7 = new Card(Rank.KING, Suit.SPADES);
        Card card8 = new Card(Rank.FOUR, Suit.HEARTS);
        Card card9 = new Card(Rank.TEN, Suit.DIAMONDS);
        Card card10 = new Card(Rank.SEVEN, Suit.CLUBS);

        ArrayList<Card> cardsHand2 = new ArrayList<>();
        Collections.addAll(cardsHand2, card6, card7, card8, card9, card10);

        PokerHand pokerHandP1 = new PokerHand(PokerHandType.HIGH_CARD);
        PokerHand pokerHandP2 = new PokerHand(PokerHandType.HIGH_CARD);

        Player player1 = new Player("Player 1", pokerHandP1);
        Player player2 = new Player("Player 2", pokerHandP2);

        PokerGameEvaluation Eval = new PokerGameEvaluation();

        assertEquals(player1.getName() + " wins with - " + pokerHandP1.getPokerHandType().getPokerHandName()
                + " of " + "Ace", Eval.tieBreaker(player1, player2, cardsHand1, cardsHand2,
                pokerHandP1.getPokerHandType(), pokerHandP2.getPokerHandType()));
    }


    @Test
    void tieBreaker2HighCardsMatch() {
        //Show the results when both hands have high cards, and the tie is broken by a high card victory
        //The hands both contain Aces and Queens, the victor goes to the 3rd highest card of 10, which is player 1

        Card card1 = new Card(Rank.ACE, Suit.CLUBS);
        Card card2 = new Card(Rank.QUEEN, Suit.DIAMONDS);
        Card card3 = new Card(Rank.TEN, Suit.DIAMONDS);
        Card card4 = new Card(Rank.SIX, Suit.SPADES);
        Card card5 = new Card(Rank.FIVE, Suit.HEARTS);

        ArrayList<Card> cardsHand1 = new ArrayList<>();
        Collections.addAll(cardsHand1, card1, card2, card3, card4, card5);

        Card card6 = new Card(Rank.QUEEN, Suit.CLUBS);
        Card card7 = new Card(Rank.ACE, Suit.SPADES);
        Card card8 = new Card(Rank.FOUR, Suit.HEARTS);
        Card card9 = new Card(Rank.TWO, Suit.DIAMONDS);
        Card card10 = new Card(Rank.SEVEN, Suit.CLUBS);

        ArrayList<Card> cardsHand2 = new ArrayList<>();
        Collections.addAll(cardsHand2, card6, card7, card8, card9, card10);

        PokerHand pokerHandP1 = new PokerHand(PokerHandType.HIGH_CARD);
        PokerHand pokerHandP2 = new PokerHand(PokerHandType.HIGH_CARD);

        Player player1 = new Player("Player 1", pokerHandP1);
        Player player2 = new Player("Player 2", pokerHandP2);

        PokerGameEvaluation Eval = new PokerGameEvaluation();

        assertEquals(player1.getName() + " wins with - " + pokerHandP1.getPokerHandType().getPokerHandName()
                + " of " + "10", Eval.tieBreaker(player1, player2, cardsHand1, cardsHand2,
                pokerHandP1.getPokerHandType(), pokerHandP2.getPokerHandType()));
    }


    @Test
    void TieBreakerFlushWinUsingHighCardRule() {
        //Show the results when both hands have poker hand type of flush
        // and the victory is of a high card of queen in hand 1

        Card card1 = new Card(Rank.TWO, Suit.HEARTS);
        Card card2 = new Card(Rank.FIVE, Suit.HEARTS);
        Card card3 = new Card(Rank.TEN, Suit.HEARTS);
        Card card4 = new Card(Rank.SEVEN, Suit.HEARTS);
        Card card5 = new Card(Rank.QUEEN, Suit.HEARTS);

        ArrayList<Card> cardsHand1 = new ArrayList<>();
        Collections.addAll(cardsHand1, card1, card2, card3, card4, card5);

        Card card6 = new Card(Rank.THREE, Suit.SPADES);
        Card card7 = new Card(Rank.FIVE, Suit.SPADES);
        Card card8 = new Card(Rank.TEN, Suit.SPADES);
        Card card9 = new Card(Rank.SEVEN, Suit.SPADES);
        Card card10 = new Card(Rank.JACK, Suit.SPADES);

        ArrayList<Card> cardsHand2 = new ArrayList<>();
        Collections.addAll(cardsHand2, card6, card7, card8, card9, card10);

        PokerHand pokerHandP1 = new PokerHand(PokerHandType.FLUSH);
        PokerHand pokerHandP2 = new PokerHand(PokerHandType.FLUSH);

        Player player1 = new Player("Player 1", pokerHandP1);
        Player player2 = new Player("Player 2", pokerHandP2);

        PokerGameEvaluation Eval = new PokerGameEvaluation();

        assertEquals(player1.getName() + " wins with - " + PokerHandType.FLUSH.getPokerHandName() + " of Queen" +
                        " 10 7 5 2 of Hearts with Queen high"
                , Eval.tieBreaker(player1, player2, cardsHand1, cardsHand2,
                        pokerHandP1.getPokerHandType(), pokerHandP2.getPokerHandType()));
    }


    @Test
    void tieBreakerStraightFlushWinUsingHighCardRule() {
        //Show the results when both hands have poker hand type of straight flush
        // and the victory is of a high card of jack in hand 2

        Card card1 = new Card(Rank.TWO, Suit.HEARTS);
        Card card2 = new Card(Rank.THREE, Suit.HEARTS);
        Card card3 = new Card(Rank.FOUR, Suit.HEARTS);
        Card card4 = new Card(Rank.FIVE, Suit.HEARTS);
        Card card5 = new Card(Rank.SIX, Suit.HEARTS);

        ArrayList<Card> cardsHand1 = new ArrayList<>();
        Collections.addAll(cardsHand1, card1, card2, card3, card4, card5);

        Card card6 = new Card(Rank.SEVEN, Suit.SPADES);
        Card card7 = new Card(Rank.EIGHT, Suit.SPADES);
        Card card8 = new Card(Rank.NINE, Suit.SPADES);
        Card card9 = new Card(Rank.TEN, Suit.SPADES);
        Card card10 = new Card(Rank.JACK, Suit.SPADES);

        ArrayList<Card> cardsHand2 = new ArrayList<>();
        Collections.addAll(cardsHand2, card6, card7, card8, card9, card10);

        PokerHand pokerHandP1 = new PokerHand(PokerHandType.STRAIGHT_FLUSH);
        PokerHand pokerHandP2 = new PokerHand(PokerHandType.STRAIGHT_FLUSH);

        Player player1 = new Player("Player 1", pokerHandP1);
        Player player2 = new Player("Player 2", pokerHandP2);

        PokerGameEvaluation Eval = new PokerGameEvaluation();

        assertEquals(player2.getName() + " wins with - " + PokerHandType.STRAIGHT_FLUSH.getPokerHandName()
                        + " of " + "Jack 10 9 8 7 of Spades with Jack high"
                , Eval.tieBreaker(player1, player2, cardsHand1, cardsHand2,
                        pokerHandP1.getPokerHandType(), pokerHandP2.getPokerHandType()));
    }


    @Test
    void tiBreakerForPairTies() {
        //Show the results when both hands have poker hand type of pair
        // and the victory is of a pair of King in hand 2

        Card card1 = new Card(Rank.TWO, Suit.HEARTS);
        Card card2 = new Card(Rank.TWO, Suit.SPADES);
        Card card3 = new Card(Rank.TEN, Suit.SPADES);
        Card card4 = new Card(Rank.SEVEN, Suit.DIAMONDS);
        Card card5 = new Card(Rank.QUEEN, Suit.HEARTS);

        ArrayList<Card> cardsHand1 = new ArrayList<>();
        Collections.addAll(cardsHand1, card1, card2, card3, card4, card5);

        Card card6 = new Card(Rank.KING, Suit.HEARTS);
        Card card7 = new Card(Rank.KING, Suit.SPADES);
        Card card8 = new Card(Rank.TEN, Suit.SPADES);
        Card card9 = new Card(Rank.SEVEN, Suit.DIAMONDS);
        Card card10 = new Card(Rank.JACK, Suit.CLUBS);

        ArrayList<Card> cardsHand2 = new ArrayList<>();
        Collections.addAll(cardsHand2, card6, card7, card8, card9, card10);

        PokerHand pokerHandP1 = new PokerHand(PokerHandType.PAIR);
        PokerHand pokerHandP2 = new PokerHand(PokerHandType.PAIR);

        Player player1 = new Player("Player 1", pokerHandP1);
        Player player2 = new Player("Player 2", pokerHandP2);

        PokerGameEvaluation Eval = new PokerGameEvaluation();

        assertEquals(player2.getName() + " wins with - " + PokerHandType.PAIR.getPokerHandName()
                        + " of " + "Kings"
                , Eval.tieBreaker(player1, player2, cardsHand1, cardsHand2,
                        pokerHandP1.getPokerHandType(), pokerHandP2.getPokerHandType()));
    }

    @Test
    void tieBreakerForPairTiesWinByHighCard() {
        //Show the results when both hands have poker hand type of pair and the values are the same and the victor
        //goes to the high card. Both hands contain a pair of 10s and the high card with be of a King in hand 1

        Card card1 = new Card(Rank.TWO, Suit.HEARTS);
        Card card2 = new Card(Rank.TEN, Suit.SPADES);
        Card card3 = new Card(Rank.TEN, Suit.CLUBS);
        Card card4 = new Card(Rank.SEVEN, Suit.DIAMONDS);
        Card card5 = new Card(Rank.KING, Suit.HEARTS);

        ArrayList<Card> cardsHand1 = new ArrayList<>();
        Collections.addAll(cardsHand1, card1, card2, card3, card4, card5);

        Card card6 = new Card(Rank.THREE, Suit.HEARTS);
        Card card7 = new Card(Rank.TEN, Suit.HEARTS);
        Card card8 = new Card(Rank.TEN, Suit.DIAMONDS);
        Card card9 = new Card(Rank.EIGHT, Suit.DIAMONDS);
        Card card10 = new Card(Rank.JACK, Suit.CLUBS);

        ArrayList<Card> cardsHand2 = new ArrayList<>();
        Collections.addAll(cardsHand2, card6, card7, card8, card9, card10);

        PokerHand pokerHandP1 = new PokerHand(PokerHandType.PAIR);
        PokerHand pokerHandP2 = new PokerHand(PokerHandType.PAIR);

        Player player1 = new Player("Player 1", pokerHandP1);
        Player player2 = new Player("Player 2", pokerHandP2);

        PokerGameEvaluation Eval = new PokerGameEvaluation();

        assertEquals(player1.getName() + " wins with - " + PokerHandType.PAIR.getPokerHandName()
                        + " of " + "10s with King high"
                , Eval.tieBreaker(player1, player2, cardsHand1, cardsHand2,
                        pokerHandP1.getPokerHandType(), pokerHandP2.getPokerHandType()));
    }


    @Test
    void tieBreakerFor3OfAKindTies() {
        //Show the results when both hands have poker hand type of 3 of a kind
        // and the victory is of a 3 of a kind of Queen in player 1


        Card card1 = new Card(Rank.TWO, Suit.HEARTS);
        Card card2 = new Card(Rank.FIVE, Suit.SPADES);
        Card card3 = new Card(Rank.QUEEN, Suit.SPADES);
        Card card4 = new Card(Rank.QUEEN, Suit.DIAMONDS);
        Card card5 = new Card(Rank.QUEEN, Suit.HEARTS);

        ArrayList<Card> cardsHand1 = new ArrayList<>();
        Collections.addAll(cardsHand1, card1, card2, card3, card4, card5);

        Card card6 = new Card(Rank.FIVE, Suit.HEARTS);
        Card card7 = new Card(Rank.KING, Suit.SPADES);
        Card card8 = new Card(Rank.NINE, Suit.SPADES);
        Card card9 = new Card(Rank.NINE, Suit.DIAMONDS);
        Card card10 = new Card(Rank.NINE, Suit.CLUBS);

        ArrayList<Card> cardsHand2 = new ArrayList<>();
        Collections.addAll(cardsHand2, card6, card7, card8, card9, card10);

        PokerHand pokerHandP1 = new PokerHand(PokerHandType.THREE_OF_A_KIND);
        PokerHand pokerHandP2 = new PokerHand(PokerHandType.THREE_OF_A_KIND);

        Player player1 = new Player("Player 1", pokerHandP1);
        Player player2 = new Player("Player 2", pokerHandP1);

        PokerGameEvaluation Eval = new PokerGameEvaluation();

        assertEquals(player1.getName() + " wins with - " + pokerHandP1.getPokerHandType().getPokerHandName()
                        + " of " + "Queens"
                , Eval.tieBreaker(player1, player2, cardsHand1, cardsHand2,
                        pokerHandP1.getPokerHandType(), pokerHandP2.getPokerHandType()));
    }


    @Test
    void tieBreakerFor4OfAKindTies() {
        //Show the results when both hands have poker hand type of 4 of a kind
        // and the victory is of a 4 of a kind of Queen in player 1


        Card card1 = new Card(Rank.TWO, Suit.HEARTS);
        Card card2 = new Card(Rank.QUEEN, Suit.CLUBS);
        Card card3 = new Card(Rank.QUEEN, Suit.SPADES);
        Card card4 = new Card(Rank.QUEEN, Suit.DIAMONDS);
        Card card5 = new Card(Rank.QUEEN, Suit.HEARTS);

        ArrayList<Card> cardsHand1 = new ArrayList<>();
        Collections.addAll(cardsHand1, card1, card2, card3, card4, card5);

        Card card6 = new Card(Rank.FIVE, Suit.HEARTS);
        Card card7 = new Card(Rank.FIVE, Suit.SPADES);
        Card card8 = new Card(Rank.NINE, Suit.SPADES);
        Card card9 = new Card(Rank.FIVE, Suit.DIAMONDS);
        Card card10 = new Card(Rank.FIVE, Suit.CLUBS);

        ArrayList<Card> cardsHand2 = new ArrayList<>();
        Collections.addAll(cardsHand2, card6, card7, card8, card9, card10);

        PokerHand pokerHandP1 = new PokerHand(PokerHandType.FOUR_OF_A_KIND);
        PokerHand pokerHandP2 = new PokerHand(PokerHandType.FOUR_OF_A_KIND);

        Player player1 = new Player("Player 1", pokerHandP1);
        Player player2 = new Player("Player 2", pokerHandP2);

        PokerGameEvaluation Eval = new PokerGameEvaluation();

        assertEquals(player1.getName() + " wins with - " + PokerHandType.FOUR_OF_A_KIND.getPokerHandName()
                        + " of " + "Queens"
                , Eval.tieBreaker(player1, player2, cardsHand1, cardsHand2,
                        pokerHandP1.getPokerHandType(), pokerHandP2.getPokerHandType()));
    }


    @Test
    void tieBreakerForFullHouseTies() {
        //Show the results when both hands have poker hand type of full house
        // and the victory is of Queens over 2s in player 1

        Card card1 = new Card(Rank.TWO, Suit.HEARTS);
        Card card2 = new Card(Rank.TWO, Suit.SPADES);
        Card card3 = new Card(Rank.QUEEN, Suit.SPADES);
        Card card4 = new Card(Rank.QUEEN, Suit.DIAMONDS);
        Card card5 = new Card(Rank.QUEEN, Suit.HEARTS);

        ArrayList<Card> cardsHand1 = new ArrayList<>();
        Collections.addAll(cardsHand1, card1, card2, card3, card4, card5);

        Card card6 = new Card(Rank.KING, Suit.HEARTS);
        Card card7 = new Card(Rank.KING, Suit.SPADES);
        Card card8 = new Card(Rank.THREE, Suit.SPADES);
        Card card9 = new Card(Rank.THREE, Suit.DIAMONDS);
        Card card10 = new Card(Rank.THREE, Suit.CLUBS);

        ArrayList<Card> cardsHand2 = new ArrayList<>();
        Collections.addAll(cardsHand2, card6, card7, card8, card9, card10);

        PokerHand pokerHandP1 = new PokerHand(PokerHandType.FULL_HOUSE);
        PokerHand pokerHandP2 = new PokerHand(PokerHandType.FULL_HOUSE);

        Player player1 = new Player("Player 1", pokerHandP1);
        Player player2 = new Player("Player 2", pokerHandP2);

        PokerGameEvaluation Eval = new PokerGameEvaluation();

        assertEquals(player1.getName() + " wins with - " + PokerHandType.FULL_HOUSE.getPokerHandName()
                        + " of " + "Queens over 2s"
                , Eval.tieBreaker(player1, player2, cardsHand1, cardsHand2,
                        pokerHandP1.getPokerHandType(), pokerHandP2.getPokerHandType()));
    }

    @Test
    void tieBreakerForTwoPairsHighCardRulesForTies() {
        //Show the results when both hands have 2 pairs of the same value: both have pairs of Kings and
        //Queens. The result will then go to the last card.
        //The victor goes to hand 2 with Ace high

        Card card1 = new Card(Rank.TWO, Suit.HEARTS);
        Card card2 = new Card(Rank.QUEEN, Suit.CLUBS);
        Card card3 = new Card(Rank.QUEEN, Suit.SPADES);
        Card card4 = new Card(Rank.KING, Suit.DIAMONDS);
        Card card5 = new Card(Rank.KING, Suit.HEARTS);

        ArrayList<Card> cardsHand1 = new ArrayList<>();
        Collections.addAll(cardsHand1, card1, card2, card3, card4, card5);

        Card card6 = new Card(Rank.KING, Suit.CLUBS);
        Card card7 = new Card(Rank.KING, Suit.SPADES);
        Card card8 = new Card(Rank.QUEEN, Suit.HEARTS);
        Card card9 = new Card(Rank.QUEEN, Suit.DIAMONDS);
        Card card10 = new Card(Rank.ACE, Suit.CLUBS);

        ArrayList<Card> cardsHand2 = new ArrayList<>();
        Collections.addAll(cardsHand2, card6, card7, card8, card9, card10);

        PokerHand pokerHandP1 = new PokerHand(PokerHandType.TWO_PAIR);
        PokerHand pokerHandP2 = new PokerHand(PokerHandType.TWO_PAIR);

        Player player1 = new Player("Player 1", pokerHandP1);
        Player player2 = new Player("Player 2", pokerHandP2);

        PokerGameEvaluation Eval = new PokerGameEvaluation();

        assertEquals(player2.getName() + " wins with - " + PokerHandType.TWO_PAIR.getPokerHandName()
                        + " of " + "Queens and Kings with Ace high"
                , Eval.tieBreaker(player1, player2, cardsHand1, cardsHand2,
                        pokerHandP1.getPokerHandType(), pokerHandP2.getPokerHandType()));
    }


    @Test
    void tieBreakerForTwoPairsTies() {
        //Show the results when both hands have 2 pairs and the high pair matches.
        //The result will then go to lower pair. Player 1 will win with Kings and 5s

        Card card1 = new Card(Rank.FIVE, Suit.HEARTS);
        Card card2 = new Card(Rank.FIVE, Suit.CLUBS);
        Card card3 = new Card(Rank.QUEEN, Suit.SPADES);
        Card card4 = new Card(Rank.KING, Suit.DIAMONDS);
        Card card5 = new Card(Rank.KING, Suit.HEARTS);

        ArrayList<Card> cardsHand1 = new ArrayList<>();
        Collections.addAll(cardsHand1, card1, card2, card3, card4, card5);

        Card card6 = new Card(Rank.KING, Suit.CLUBS);
        Card card7 = new Card(Rank.KING, Suit.SPADES);
        Card card8 = new Card(Rank.QUEEN, Suit.HEARTS);
        Card card9 = new Card(Rank.TWO, Suit.DIAMONDS);
        Card card10 = new Card(Rank.TWO, Suit.DIAMONDS);

        ArrayList<Card> cardsHand2 = new ArrayList<>();
        Collections.addAll(cardsHand2, card6, card7, card8, card9, card10);

        PokerHand pokerHandP1 = new PokerHand(PokerHandType.TWO_PAIR);
        PokerHand pokerHandP2 = new PokerHand(PokerHandType.TWO_PAIR);

        Player player1 = new Player("Player 1", pokerHandP1);
        Player player2 = new Player("Player 2", pokerHandP2);

        PokerGameEvaluation Eval = new PokerGameEvaluation();

        assertEquals(player1.getName() + " wins with - " + PokerHandType.TWO_PAIR.getPokerHandName()
                        + " of " + "Kings and 5s"
                , Eval.tieBreaker(player1, player2, cardsHand1, cardsHand2,
                        pokerHandP1.getPokerHandType(), pokerHandP2.getPokerHandType()));
    }
}

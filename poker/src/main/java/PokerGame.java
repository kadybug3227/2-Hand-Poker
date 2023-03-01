import java.util.ArrayList;

public class PokerGame {

    /*
     PokerGame class simulates a poker game:
    /Responsible for creating the Deck, players, hands, poker hands, dealing cards to the hands
     and communicating with the PokerGameEvaluation class to determine the winner
     */


    public static void main(String[] args) {
        //Cards per hand
        int cardsPerHand;
        PokerGameEvaluation eval;
        Deck d1;
        Hand h1, h2;                //Hands of cards
        Player player1, player2;
        PokerHandType player1PokerHandType, player2PokerHandType; //The poker hands which will hold the type of
                                                                    // poker hand: pair, full house, etc


        cardsPerHand = 5;
        eval = new PokerGameEvaluation();
        d1 = new Deck();
        h1 = new Hand();
        h2 = new Hand();


        // Populate and shuffle the deck of 52 cards
        d1.populate();
        d1.shuffle();

        //An array to hold all the hands in play
        Hand[] hands = {h1, h2};

        //Deal cards to the hands
        d1.deal(hands, cardsPerHand);

        //Call the PokerGameEvaluation class to evaluate cards into poker hand types
        //Returns a type of PokerHandType (2pair, fullHouse, etc.)
        player1PokerHandType = eval.checkHands(h1.cards);
        player2PokerHandType = eval.checkHands(h2.cards);


        //create PokerHand instances for the players, using the PokerHandType
        PokerHand p1PokerHand = new PokerHand(player1PokerHandType);
        PokerHand p2PokerHand = new PokerHand(player2PokerHandType);

        //create the players' instances with their PokerHand instances
        player1 = new Player("Player 1", p1PokerHand);
        player2 = new Player("Player 2", p2PokerHand);


        //Show the players and their hands
        System.out.println(player1.getName());
        System.out.println(h1.showHand());

        System.out.println(player2.getName());
        System.out.println(h2.showHand());


        //Pass the poker hands, the players and the PokerGameEvaluation instance to the calculateWinner method
        determineWinner(player1PokerHandType, player2PokerHandType, player1, player2,
                eval, h1.cards, h2.cards);

    }


    private static void determineWinner(PokerHandType player1PokerHandType, PokerHandType player2PokerHandType,
                                        Player player1, Player player2, PokerGameEvaluation eval,
                                        ArrayList<Card> hand1Cards, ArrayList<Card> hand2Cards) {
        //Communicates with the PokerGameEvaluation class to determine a winner and print out
        //the winning hand details
        String winningPokerHand;

        if (player1PokerHandType.getPointValue() == player2PokerHandType.getPointValue()) {
            winningPokerHand = eval.tieBreaker(player1, player2, hand1Cards, hand2Cards, player1PokerHandType,
                    player2PokerHandType);
        } else {
            if(player1PokerHandType.getPointValue() > player2PokerHandType.getPointValue()) {
                PokerHand pokerHandP1 = eval.createThePokerHand(hand1Cards, player1PokerHandType);
                winningPokerHand = player1.getName() + " wins with - " + pokerHandP1.toString();

            }else{
                PokerHand pokerHandP2 = eval.createThePokerHand(hand2Cards, player2PokerHandType);
                winningPokerHand = player2.getName() + " wins with - " + pokerHandP2.toString();
            }
        }
        System.out.println(winningPokerHand);
    }
}
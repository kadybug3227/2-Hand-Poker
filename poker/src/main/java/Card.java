/*
Card class: consists of 2 enum type instance variables, which are suit and rank. These are used to create the deck
of 52 cards.
 */

public class Card{

    private Suit suit;
    private Rank rank;


    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }


    //public methods
    public String getSuit(){
        return suit.printSuit();
    }
    public int getRank(){
        return rank.getRankValue();
    }
    public String getRankString(){
        return rank.getRankString();
    }

    public Rank getRankEnum(){
        return this.rank;
    }

    public Suit getSuitEnum(){
        return this.suit;
    }


    public String toString(){
        String str = "";
            str += rank.getRankString() + " of " +
                    suit.printSuit();
        return str;
    }
}
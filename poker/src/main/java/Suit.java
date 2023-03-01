//Enum rank, to store all the constant variables of the suits of cards: Hearts, Spades, Diamonds and Clubs


public enum Suit {
    //public because other classes need access to this enu class

    HEARTS("Hearts"),
    SPADES("Spades"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs");

    private final String suitType;

    //Constructors are private
    private Suit(String suitType){
        this.suitType = suitType; //this will represent each member of the suits
    }

    //Public method
    public String printSuit(){
        //will return the suit
        return suitType;
    }
}

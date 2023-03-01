//The player class, allows for the creation of players with names

public class Player {
    private String name;
    private PokerHand pokerHand;

    public Player(String name, PokerHand pokerHand) {
        this.name = name;
        this.pokerHand = pokerHand;
    }

    public String getName() {
        return name;
    }
    public PokerHand getPokerHand(){
        return pokerHand;
    }

}

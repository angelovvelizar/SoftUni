package Exercise.CardRank;

public class Card {
    private CardRank cardRank;
    private CardSuit cardSuit;



    public Card(CardRank cardRank, CardSuit cardSuit){
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    public int calculatePower(int power, int cardSuit){
        return power + cardSuit;
    }
}

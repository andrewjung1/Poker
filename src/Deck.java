import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {
    ArrayList<Card> deckArray = new ArrayList<Card>();
    String currentSuit;

    public Deck() {
        for(var s = 1; s <= 4; s++) {
            for (var v = 1; v <= 13; v++) {
                if(s == 1){
                    currentSuit = "♠️";
                } else if(s == 2){
                    currentSuit = "♥️";
                } else if(s == 3){
                    currentSuit = "♦️";
                } else if(s == 4){
                    currentSuit = "♣️";
                }

                Card newCard = new Card(v,currentSuit);
                deckArray.add(newCard);
            }
        }
    }

    public Card drawCard(){
        int randomNumber = ThreadLocalRandom.current().nextInt(0, deckArray.size());
        Card cardDrawn = deckArray.get(randomNumber);
        deckArray.remove(cardDrawn);
        return cardDrawn;
    }

    public void printWholeDeck(){
        Helpers.printCardsInDeck(this.deckArray);
    }


}




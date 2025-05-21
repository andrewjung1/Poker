import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Card> handOfCards = new ArrayList<Card>();
    static String handType;

    public static void main(String[] args) {


        Deck deck = new Deck();
        //deck.printWholeDeck();
        drawCards(deck);
        discardCards(deck);
        Helpers.printCardsInDeck(handOfCards);
        String currentHand = identifyHand();
        System.out.println("You have a " + currentHand);

    }

    public static void drawCards(Deck deck) {
        handOfCards.add(deck.drawCard());
        handOfCards.add(deck.drawCard());
        handOfCards.add(deck.drawCard());
        handOfCards.add(deck.drawCard());
        handOfCards.add(deck.drawCard());
        Helpers.printCardsInDeck(handOfCards);
    }

    public static void discardCards(Deck deck){
        int discardedCardIndex;
        System.out.println("Would you like to discard cards? 'discard' or 'keep'");
        String askForDiscard = scanner.nextLine();
        if(askForDiscard.equals("discard")){

            System.out.println("Card '0' '1' or '2'");
            String nextCommand = scanner.nextLine();

            String[] cardsToDiscard = nextCommand.split(",");
            for(var i = 0; i < cardsToDiscard.length; i++){

                discardedCardIndex = Integer.parseInt(cardsToDiscard[i]);
                if(discardedCardIndex <= handOfCards.size()){
                    handOfCards.remove(discardedCardIndex);
                    handOfCards.add(discardedCardIndex, deck.drawCard());

                }
            }





        }
    }

    public static String identifyHand() {
        HashMap<String, Integer> amountOfCardValue = new HashMap<String, Integer>();
        for(int i = 1; i <= 13; i++){

        }
//
//        amountOfCardValue.put("A", 1);
//        amountOfCardValue.put("3", 1);
//        amountOfCardValue.put("8", 1);
//        amountOfCardValue.put("J", 2);
//        amountOfCardValue.put(handOfCards.get(0).cardName, amountOfCardValue.get(handOfCards.get(0).cardName) + 1);


        // Full breakdown
        for(int i=0; i<handOfCards.size(); i++) {
            String currentCardName = handOfCards.get(i).cardName;
            int currentCountOfCardName = amountOfCardValue.getOrDefault(currentCardName, 0);
            amountOfCardValue.put(currentCardName, currentCountOfCardName + 1);
        }

        //System.out.println(amountOfCardValue.size() + "sdfsdf");

        String mostFrequentCardInHand = "A";
        int amountOfMostFrequentCard = 0;
        for(int i = 1; i <= 13; i++){
            String name;
            if(i == 1){
                name = "A";
            } else if (i == 11){
                name = "J";
            } else if (i == 12){
                name = "Q";
            } else if (i == 13){
                name = "K";
            } else {
                name = Integer.toString(i);
            }
            //System.out.println(amountOfCardValue.get(name) + " this");
            if(amountOfCardValue.getOrDefault(name, 0) > amountOfMostFrequentCard){
                amountOfMostFrequentCard = amountOfCardValue.get(name);
                mostFrequentCardInHand = name;
            }

        }

        System.out.println(mostFrequentCardInHand + " = most frequent");
//        int mostFrequentValue = 0;
//        HashMap<String, Integer> ListOfCardValues = new HashMap<String, Integer>();
//        for(int i = 0; i < 13; i++){
//            if(i == 0){
//                ListOfCardValues.put("Ace", i);
//            }
//            if(i > 0 && i < 10){
//                ListOfCardValues.put(String.valueOf(i),i);
//            } else if(i == 10){
//                ListOfCardValues.put("Jack",i);
//            } else if(i == 11){
//                ListOfCardValues.put("Queen",i);
//            } else if(i == 12){
//                ListOfCardValues.put("King",i);
//            }
//        }
//        int[] listOfValues = new int[13];
//        for(var i = 0; i < 13; i++){
//            listOfValues[i] = 0;
//        }
//        for (var i = 0; i < handOfCards.size(); i++) {
//            listOfValues[handOfCards.get(i).value - 1] += 1;
//        }
//        for(var i = 0; i < listOfValues.length; i ++){
//            if(listOfValues[i] >= listOfValues[mostFrequentValue]){
//                mostFrequentValue = i + 1;
//            }
//        }
        //System.out.println(mostFrequentValue);

        if (amountOfMostFrequentCard == 4){
            return "Four of a kind of " + mostFrequentCardInHand;
        }
         else if (amountOfMostFrequentCard == 3) {
            return "Three of a kind of " + mostFrequentCardInHand;
        } else if(amountOfMostFrequentCard == 2){
            return "Pair of " + mostFrequentCardInHand;
        } else {
            Card highestValue = handOfCards.getFirst();
            for (int i = 1; i < handOfCards.size(); i++) {
                if (handOfCards.get(i).value > highestValue.value) {
                    highestValue = handOfCards.get(i);
                }
            }
            return "High card of " + highestValue.value;
        }



//        for (var i = 0; i < handOfCards.size(); i++) {
//            for (var j = 0; j < handOfCards.size(); j++) {
//                if (i != j) {
//                    if (handOfCards.get(i).value == handOfCards.get(j).value) {
//                        //System.out.println("You have a pair of " + handOfCards.get(i).value);
//                        return new HandType(handOfCards.get(i), "Pair");
//                    }
//                }
//            }
//        }

    }
}
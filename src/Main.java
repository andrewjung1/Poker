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
        //Draw 5 cards into hand and prints in console
        handOfCards.add(deck.drawCard());
        handOfCards.add(deck.drawCard());
        handOfCards.add(deck.drawCard());
        handOfCards.add(deck.drawCard());
        handOfCards.add(deck.drawCard());
        Helpers.printCardsInDeck(handOfCards);
    }

    public static void discardCards(Deck deck) {
        int discardedCardIndex;
        System.out.println("Would you like to discard cards? 'discard' or 'keep'");
        String askForDiscard = scanner.nextLine();
        if (askForDiscard.equals("discard")) {

            System.out.println("Card '0' '1' or '2'");
            String nextCommand = scanner.nextLine();

            //
            String[] cardsToDiscard = nextCommand.split(",");
            for (var i = 0; i < cardsToDiscard.length; i++) {

                discardedCardIndex = Integer.parseInt(cardsToDiscard[i]);
                if (discardedCardIndex <= handOfCards.size()) {
                    handOfCards.remove(discardedCardIndex);
                    handOfCards.add(discardedCardIndex, deck.drawCard());

                }
            }
        }
    }

    public static String identifyHand() {
        HashMap<String, Integer> amountOfCardValue = new HashMap<String, Integer>();

        // Adds all cards in hand into HashMap
        for (int i = 0; i < handOfCards.size(); i++) {
            String currentCardName = handOfCards.get(i).cardName;
            int currentCountOfCardName = amountOfCardValue.getOrDefault(currentCardName, 0);
            amountOfCardValue.put(currentCardName, currentCountOfCardName + 1);
        }

        //
        String mostFrequentCardInHand = "A";
        int amountOfMostFrequentCard = 0;
        for (int i = 1; i <= 13; i++) {
            String name;
            if (i == 1) {
                name = "A";
            } else if (i == 11) {
                name = "J";
            } else if (i == 12) {
                name = "Q";
            } else if (i == 13) {
                name = "K";
            } else {
                name = Integer.toString(i);
            }
            //
            if (amountOfCardValue.getOrDefault(name, 0) > amountOfMostFrequentCard) {
                amountOfMostFrequentCard = amountOfCardValue.get(name);
                mostFrequentCardInHand = name;
            }

        }

        //System.out.println(mostFrequentCardInHand + " = most frequent");

        //Returns hand based on card with the highest frequency
        if (amountOfMostFrequentCard == 4) {
            return "Four of a kind of " + mostFrequentCardInHand;
        } else if (amountOfMostFrequentCard == 3) {
            return "Three of a kind of " + mostFrequentCardInHand;
        } else if (amountOfMostFrequentCard == 2) {
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
    }
}

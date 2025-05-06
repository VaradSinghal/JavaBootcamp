import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {

    // Method to create a deck of cards
    public static ArrayList<String> initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        ArrayList<String> deck = new ArrayList<>();

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + " of " + suit);
            }
        }

        return deck;
    }

    // Method to shuffle the deck
    public static void shuffleDeck(ArrayList<String> deck) {
        Collections.shuffle(deck);
    }

    // Method to distribute cards to players
    public static void distributeCards(ArrayList<String> deck, int players, int cardsPerPlayer) {
        int totalCards = players * cardsPerPlayer;
        if (totalCards > deck.size()) {
            System.out.println("Not enough cards to distribute.");
            return;
        }

        ArrayList<String>[] hands = new ArrayList[players];
        for (int i = 0; i < players; i++) {
            hands[i] = new ArrayList<>();
        }

        int index = 0;
        for (String card : deck.subList(0, totalCards)) {
            hands[index].add(card);
            index = (index + 1) % players;
        }

        // Print hands of players
        for (int i = 0; i < players; i++) {
            System.out.println("Player " + (i + 1) + ": " + hands[i]);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> deck = initializeDeck();
        shuffleDeck(deck);

        int players = 4;
        int cardsPerPlayer = 5;
        distributeCards(deck, players, cardsPerPlayer);
    }
}

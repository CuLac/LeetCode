package Daily.Medium;

/*
950. Reveal Cards In Increasing Order
You are given an integer array deck. There is a deck of cards where every card has a unique integer. The integer on the ith card is deck[i].

You can order the deck in any order you want. Initially, all the cards start face down (unrevealed) in one deck.

You will do the following steps repeatedly until all cards are revealed:

Take the top card of the deck, reveal it, and take it out of the deck.
If there are still cards in the deck then put the next top card of the deck at the bottom of the deck.
If there are still unrevealed cards, go back to step 1. Otherwise, stop.
Return an ordering of the deck that would reveal the cards in increasing order.

Note that the first entry in the answer is considered to be the top of the deck.



Example 1:

Input: deck = [17,13,11,2,3,5,7]
Output: [2,13,3,11,5,17,7]
Explanation:
We get the deck in the order [17,13,11,2,3,5,7] (this order does not matter), and reorder it.
After reordering, the deck starts as [2,13,3,11,5,17,7], where 2 is the top of the deck.
We reveal 2, and move 13 to the bottom.  The deck is now [3,11,5,17,7,13].
We reveal 3, and move 11 to the bottom.  The deck is now [5,17,7,13,11].
We reveal 5, and move 17 to the bottom.  The deck is now [7,13,11,17].
We reveal 7, and move 13 to the bottom.  The deck is now [11,17,13].
We reveal 11, and move 17 to the bottom.  The deck is now [13,17].
We reveal 13, and move 17 to the bottom.  The deck is now [17].
We reveal 17.
Since all the cards revealed are in increasing order, the answer is correct.
Example 2:

Input: deck = [1,1000]
Output: [1,1000]

 */

import com.google.gson.Gson;

import java.util.*;

public class Q950_Reveal_Cards_In_Increasing_Order {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck); // Sort the deck in increasing order

        int n = deck.length;
        int[] result = new int[n];
        Deque<Integer> indices = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            indices.add(i); // Initialize deque with indices 0, 1, 2, ..., n-1
        }

        for (int card : deck) {
            int idx = indices.poll(); // Get the next available index
            result[idx] = card; // Place the card in the result array
            if (!indices.isEmpty()) {
                indices.add(indices.poll()); // Move the used index to the end of deque
            }
        }

        return result;
    }
}

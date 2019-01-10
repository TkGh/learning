package leetCode1;

import java.util.Arrays;

public class RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        if (deck.length == 1) return deck;

        Arrays.sort(deck);

        int[] res = new int[deck.length];

        for (int i = 0; i < res.length; i += 2) {
            res[i] = deck[i / 2];
        }


        return res;
    }
}

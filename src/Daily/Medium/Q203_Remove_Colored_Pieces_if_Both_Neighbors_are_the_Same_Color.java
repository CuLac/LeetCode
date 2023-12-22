package Daily.Medium;

/*

2038. Remove Colored Pieces if Both Neighbors are the Same Color
There are n pieces arranged in a line, and each piece is colored either by 'A' or by 'B'.
You are given a string colors of length n where colors[i] is the color of the ith piece.

Alice and Bob are playing a game where they take alternating turns removing pieces from the line. In this game, Alice moves first.

Alice is only allowed to remove a piece colored 'A' if both its neighbors are also colored 'A'. She is not allowed to remove pieces that are colored 'B'.
Bob is only allowed to remove a piece colored 'B' if both its neighbors are also colored 'B'. He is not allowed to remove pieces that are colored 'A'.
Alice and Bob cannot remove pieces from the edge of the line.
If a player cannot make a move on their turn, that player loses and the other player wins.
Assuming Alice and Bob play optimally, return true if Alice wins, or return false if Bob wins.



Example 1:

Input: colors = "AAABABB"
Output: true
Explanation:
AAABABB -> AABABB
Alice moves first.
She removes the second 'A' from the left since that is the only 'A' whose neighbors are both 'A'.

Now it's Bob's turn.
Bob cannot make a move on his turn since there are no 'B's whose neighbors are both 'B'.
Thus, Alice wins, so return true.
Example 2:

Input: colors = "AA"
Output: false
Explanation:
Alice has her turn first.
There are only two 'A's and both are on the edge of the line, so she cannot move on her turn.
Thus, Bob wins, so return false.

 */

public class Q203_Remove_Colored_Pieces_if_Both_Neighbors_are_the_Same_Color {
    public static boolean winnerOfGame(String colors) {
        int n = colors.length();
        if (n < 3) {
            return false;
        }
        char [] arr = colors.toCharArray();
        int numbA = 0;
        int numbB = 0;
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] == arr[i-1] && arr[i] == arr[i+1] && arr[i] == 'A') {
                numbA++;
            }
            if (arr[i] == arr[i-1] && arr[i] == arr[i+1] && arr[i] == 'B') {
                numbB++;
            }
        }
        System.out.println("NumbA=" + numbA + "|NumbB=" + numbB);
        return numbA > numbB;
    }

    public static void main(String[] args) {
        String color = "ABBBBBBBAAA";
        winnerOfGame(color);
    }
}

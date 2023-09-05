package Daily.Medium;

/*

319. Bulb Switcher
There are n bulbs that are initially off. You first turn on all the bulbs, then you turn off every second bulb.

On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on).
For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb.

Return the number of bulbs that are on after n rounds.


Example 1:


Input: n = 3
Output: 1
Explanation: At first, the three bulbs are [off, off, off].
After the first round, the three bulbs are [on, on, on].
After the second round, the three bulbs are [on, off, on].
After the third round, the three bulbs are [on, off, off].
So you should return 1 because there is only one bulb is on.


Example 2:

Input: n = 0
Output: 0


Example 3:

Input: n = 1
Output: 1

 */

public class Q319_Bulb_Switcher {
    /* Initially, all bulbs are turned off. In the first round, all bulbs are turned on.
     In the second round, every second bulb is toggled (i.e., if a bulb is on, it is turned off; if it is off, it is turned on).
     In the third round, every third bulb is toggled, and so on until the nth round.
     The problem asks to determine how many bulbs are on after n rounds of toggling.
     A key observation is that a bulb i will only be toggled in the jth round if j is a factor of i.
     Therefore, a bulb i will be on at the end if and only if the number of factors of i is odd.
     A number has an odd number of factors if and only if it is a perfect square.
     Therefore, the problem is reduced to counting the number of perfect squares less than or equal to n.
     This can be done by taking the square root of n and truncating the result to an integer.
     Since the number of perfect squares less than or equal to n is equal to the integer part of the square root of n, this gives the answer to the problem.
     */
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}

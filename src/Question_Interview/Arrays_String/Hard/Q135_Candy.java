package Question_Interview.Arrays_String.Hard;

/*

135. Candy
There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.



Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.

 */

import com.google.gson.Gson;

import java.util.Arrays;

public class Q135_Candy {
    public static int candy(int[] ratings) {
        if (ratings.length == 0) {
            return 0;
        }
        int [] cendies = new int[ratings.length];
        Arrays.fill(cendies, 1);

        //duyet tu dau mang den cuoi de xu ly truong hop chuoi rating tang dan tu trai qua phai
        for(int i=1; i<cendies.length; i++){
            if(ratings[i]>ratings[i-1]){
                cendies[i]=cendies[i-1]+1;
            }
        }

        //duyet nguoc tu cuoi mang de xu ly cac truong hop co rating lon hon nhung gia tri candy nho hon
        for(int i=cendies.length-2; i>=0; i--){
            if(ratings[i]>ratings[i+1] && cendies[i]<cendies[i+1]+1){
                cendies[i]=cendies[i+1]+1;
            }
        }

        int sum=0;
        for(int i=0; i<cendies.length; ++i){
            sum+=cendies[i];
        }
        return sum;
    }
}

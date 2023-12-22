package Daily.Medium;

/*
2353. Design a Food Rating System
Design a food rating system that can do the following:

Modify the rating of a food item listed in the system.
Return the highest-rated food item for a type of cuisine in the system.
Implement the FoodRatings class:

- FoodRatings(String[] foods, String[] cuisines, int[] ratings) Initializes the system.
The food items are described by foods, cuisines and ratings, all of which have a length of n.
    +) foods[i] is the name of the ith food,
    +) cuisines[i] is the type of cuisine of the ith food, and
    +) ratings[i] is the initial rating of the ith food.
- void changeRating(String food, int newRating) Changes the rating of the food item with the name food.
- String highestRated(String cuisine) Returns the name of the food item that has the highest rating for the given type of cuisine.
If there is a tie, return the item with the lexicographically smaller name.

Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order,
that is, either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i] comes before y[i] in alphabetic order.

 */

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Q2353_Design_a_Food_Rating_System {
    public class Info{
        String food;
        String cuisine;
        int rating;
        public Info(String food,String cuisine,int rating){
            this.food=food;
            this.cuisine=cuisine;
            this.rating=rating;
        }
    }
    Map<String, PriorityQueue<Info>> cuisineMap;
    Map<String, Info> foodMap;

    public Q2353_Design_a_Food_Rating_System(String[] foods, String[] cuisines, int[] ratings) {
        cuisineMap=new HashMap<>();
        foodMap=new HashMap<>();
        for(int i=0; i<foods.length; i++){
            Info combo=new Info(foods[i],cuisines[i],ratings[i]);
            foodMap.put(foods[i],combo);
            if(cuisineMap.containsKey(cuisines[i])){
                cuisineMap.get(cuisines[i]).add(combo);
            }
            else{
                PriorityQueue<Info> pq= new PriorityQueue<>((a, b) -> {
                    int result = b.rating - a.rating;
                    if (result == 0) {
                        return (a.food).compareTo(b.food);
                    }
                    return result;
                });
                pq.add(combo);
                cuisineMap.put(cuisines[i],pq);
            }
        }
    }

    public void changeRating(String food, int newRating) {
        Info prev=foodMap.get(food);
        Info curr= new Info(food,prev.cuisine,newRating);
        foodMap.put(food,curr);
        prev.food="";
        cuisineMap.get(prev.cuisine).add(curr);



    }

    public String highestRated(String cuisine) {
        while( cuisineMap.get(cuisine).peek().food.equals("")){
            cuisineMap.get(cuisine).remove();
        }
        return cuisineMap.get(cuisine).peek().food;

    }
}

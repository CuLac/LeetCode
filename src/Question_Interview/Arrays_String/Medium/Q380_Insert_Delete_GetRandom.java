package Question_Interview.Arrays_String.Medium;

/*

380. Insert Delete GetRandom O(1)
Implement the RandomizedSet class:

RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity.



Example 1:

Input
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]
Output
[null, true, false, true, 2, true, false, 2]

Explanation
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
randomizedSet.insert(2); // 2 was already in the set, so return false.
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.


 */

import com.google.gson.Gson;

import java.util.*;

public class Q380_Insert_Delete_GetRandom {
    List<Integer> nums;
    Map<Integer, Integer> idxMap;
    Random random;
    public Q380_Insert_Delete_GetRandom() {
        nums = new ArrayList<>();
        idxMap = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (idxMap.containsKey(val)) {
            return false;
        }
        nums.add(val);
        idxMap.put(val, nums.size());
        return true;
    }

    public boolean remove(int val) {
        System.out.println("List org=" + new Gson().toJson(nums));
        System.out.println("Map org=" + idxMap);
        if (!idxMap.containsKey(val)) {
            return false;
        }
        int idx = idxMap.get(val);
        int lastIdx = nums.size() - 1;
        System.out.println("lastIdx=" + lastIdx);
        if (idx != nums.size()) {
            int lastVal = nums.get(lastIdx);
            nums.set(idx - 1, lastVal);
            idxMap.put(lastVal, idx);
        }
        nums.remove(lastIdx);
        idxMap.remove(val);
        System.out.println("Nums=" + new Gson().toJson(nums) + "|Map=" + idxMap);
        return true;
    }

    public int getRandom() {
        int rand = random.nextInt(nums.size());
        System.out.println("Rand=" + rand);
        return nums.get(rand);
    }
}

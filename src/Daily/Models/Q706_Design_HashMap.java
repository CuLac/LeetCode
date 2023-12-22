package Daily.Models;

/*

706. Design HashMap
Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

MyHashMap() initializes the object with an empty map.
void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.


Example 1:

Input
["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
Output
[null, null, null, 1, -1, null, 1, null, -1]

Explanation
MyHashMap myHashMap = new MyHashMap();
myHashMap.put(1, 1); // The map is now [[1,1]]
myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]

 */

import java.util.Arrays;

public class Q706_Design_HashMap {
    private int[] data;

    public Q706_Design_HashMap() {
        data = new int[1000001];
        Arrays.fill(data, -1);
    }

    public void put(int key, int value) {
        data[key] = value;
    }

    public int get(int key) {
        return data[key];
    }

    public void remove(int key) {
        data[key] = -1;
    }

    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */

    //using LinkedList
    private class Node {
        private int key;
        private int value;
        private Node next;

        public Node(int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    static final int size = 19997;
    static final int mult = 12582917;
    Node[] listNode;

    public void MyHashMap() {
        this.listNode = new Node[size];
    }

    private int hash(int key) {
        return (int) ((long) key * mult % size);
    }

    public void put_v2(int key, int value) {
        remove(key);
        int h = hash(key);
        Node node = new Node(key, value, listNode[h]);
        listNode[h] = node;
    }

    public int get_v2(int key) {
        int h = hash(key);
        Node node = listNode[h];
        for (; node != null; node = node.next)
            if (node.key == key) return node.value;
        return -1;
    }

    public void remove_v2(int key) {
        int h = hash(key);
        Node node = listNode[h];
        if (node == null) return;
        if (node.key == key) listNode[h] = node.next;
        else for (; node.next != null; node = node.next)
            if (node.next.key == key) {
                node.next = node.next.next;
                return;
            }
    }

}

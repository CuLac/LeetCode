package Daily.Medium;

import com.google.gson.Gson;

import java.util.*;

/*
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left).
Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

*/
public class Q735_Asteroid_Collision {
    public static int[] asteroidCollision(int[] asteroids) {
        if (asteroids.length < 2) {
            return asteroids;
        }
        int n = asteroids.length;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // stack bat dau bang cach luu cac gia tri positive
            if (queue.isEmpty() || queue.peek() * asteroids[i] > 0) {
                queue.push(asteroids[i]);
            } else {
                // kiem tra neu stack k empty va dang chua cac gia tri positive
                // trường hợp 2 hành tinh có va chạm và giá trị trong stack bé hơn
                // loai bo tat ca các giá trị positive có value be hon asteroids[i]
                while (!queue.isEmpty() && queue.peek() > 0 && queue.peek() < Math.abs(asteroids[i])) {
                    queue.pop();
                }

                while (!queue.isEmpty() && queue.peek() < 0 && asteroids[i] > Math.abs(queue.peek())) {
                    queue.pop();
                }

                // kiem tra truong hop queue co gia tri va = gia tri asteroids[i] thi loai bo ca 2 => khong dua vao vong lap while => kiem tra gia tri tiep theo
                if (!queue.isEmpty() && ((queue.peek() == Math.abs(asteroids[i])) || Math.abs(queue.peek()) == asteroids[i])) {
                    queue.pop();
                } else {
                    if (queue.isEmpty()) {
                        queue.push(asteroids[i]);
                    }
                }
            }
        }
        int [] result = new int[queue.size()];
        int size = queue.size();
        while (!queue.isEmpty()) {
            result[--size] = queue.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        Gson gson = new Gson();
        int[] arr = {-2,-1,1,2};
        System.out.println(gson.toJson(asteroidCollision(arr)));
    }
}

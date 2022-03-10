package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ClimbingStairs {
    //https://leetcode.com/problems/climbing-stairs/
    //https://www.youtube.com/watch?v=Y0lT9Fck7qI&ab_channel=NeetCode
    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(5));
    }

    public int climbStairs(int n) {
        int one = 1, two = 1;
        for (int i = 0; i < n - 1; i++) {
            int temp = one;
            one = one + two;
            two = temp;
        }
        return one;
    }

    //DFS
    public int climbStairs2(int n) {
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (num == n) {
                result++;
            } else if (num < n) {
                queue.offer(num + 1);
                queue.offer(num + 2);
            }
        }
        return result;
    }
}

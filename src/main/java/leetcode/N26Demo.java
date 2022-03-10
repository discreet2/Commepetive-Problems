package leetcode;

import java.util.HashMap;
//Given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

//      Given A = [1, 2, 3], the function should return 4.

//    Given A = [−1, −3], the function should return 1.
public class N26Demo {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int res = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                map.put(A[i], A[i]);
            }
        }
        for (int i = 1; i <= A.length + 1; i++) {
            if (!map.containsKey(i)) return i;
        }
        return res;
    }

    public static void main(String[] args) {
        N26Demo demo = new N26Demo();
        int nums[] = {1, 3, 6, 4, 1, 2};
        System.out.println(demo.solution(nums));
        int nums2[] = {-1, -3};
        System.out.println(demo.solution(nums2));
    }
}

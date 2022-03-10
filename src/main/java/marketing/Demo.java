package marketing;

import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        Demo demo = new Demo();
        int nums[] = {1, 3, 6, 4, 1, 2};
        System.out.println(demo.solution(nums));
        int nums2[] = {1, 2, 3};
        System.out.println(demo.solution(nums2));
        int nums3[] = {-1,-3};
        System.out.println(demo.solution(nums3));
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int result = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                map.put(A[i], A[i]);
            }
        }
        for (int i = 1; i <= A.length+1; i++) {
            if (!map.containsKey(i)) return i;
        }
        return result;
    }
}

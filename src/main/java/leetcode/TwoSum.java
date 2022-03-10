package leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/
public class TwoSum {
    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int nums[] = {3, 2, 4};
        int res[] = ts.twoSum2(nums, 6);
        System.out.println(res[0] + " " + res[1]);
    }


    public void test() {

    }

    public int[] twoSum2(int[] nums, int target) {
        int res[] = {-1, -1};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }

    //https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    public int[] twoSum(int[] nums, int target) {
        int res[] = {-1, -1};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i == j) continue;
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }
}

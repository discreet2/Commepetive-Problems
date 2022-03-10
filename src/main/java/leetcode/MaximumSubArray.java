package leetcode;

import java.util.Arrays;
import java.util.Collections;

public class MaximumSubArray {
    //https://leetcode.com/problems/maximum-subarray/
    public static void main(String[] args) {
        MaximumSubArray maximumSubArray = new MaximumSubArray();
        int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maximumSubArray.maxSubArray(nums));
        int nums2[] = {5, 4, -1, 7, 8};
        System.out.println(maximumSubArray.maxSubArray(nums2));
    }

    public int maxSubArray(int[] nums) {
        int currentMax = nums[0], globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], (currentMax + nums[i]));
            if (currentMax > globalMax) {
                globalMax = currentMax;
            }
        }
        return globalMax;
    }
}

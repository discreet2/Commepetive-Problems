package leetcode;

import java.util.Arrays;
import java.util.Collections;

public class MaximumProductSubarray {
    //https://leetcode.com/problems/maximum-product-subarray/
    public static void main(String[] args) {
        MaximumProductSubarray productSubarray = new MaximumProductSubarray();
        int nums[] = {-2, 0, -1};
        System.out.println(productSubarray.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE, min = 1, max = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                min = 1;
                max = 1;
                result = Math.max(result, 0);
                continue;
            }
            int temp = max * nums[i];
            max = Collections.max(Arrays.asList(max * nums[i], min * nums[i], nums[i]));
            min = Collections.min(Arrays.asList(temp, min * nums[i], nums[i]));
            result = Math.max(result, max);
        }
        return result;
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsDiff {
    //https://leetcode.com/problems/minimum-absolute-difference/
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int minAbsDiff = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (Math.abs(arr[i] - arr[i + 1]) < minAbsDiff) {
                minAbsDiff = Math.abs(arr[i] - arr[i + 1]);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (Math.abs(arr[i] - arr[i+1]) == minAbsDiff) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i+1]);
                result.add(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumAbsDiff minimumAbsDiff = new MinimumAbsDiff();
        int nums[] = {4, 2, 1, 3};
        System.out.println(minimumAbsDiff.minimumAbsDifference(nums));
        int nums2[] = {3, 8, -10, 23, 19, -4, -14, 27};
        System.out.println(minimumAbsDiff.minimumAbsDifference(nums2));
        int nums3[] = {1, 3, 6, 10, 15};
        System.out.println(minimumAbsDiff.minimumAbsDifference(nums3));
    }
}

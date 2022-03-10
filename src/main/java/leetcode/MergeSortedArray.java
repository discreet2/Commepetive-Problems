package leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/merge-sorted-array/
public class MergeSortedArray {
    public static void main(String[] args) {
        int nums1[] = {1,2,3,0,0,0};
        int nums2[] = {2,5,6};
        MergeSortedArray msa = new MergeSortedArray();
        msa.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums2.length);
        }
        int i = m - 1;
        int j = n - 1;
        int k = nums1.length - 1;
        while (k >= 0) {
            if (i < 0) {
                nums1[k--] = nums2[j--];
                continue;
            }
            if (j < 0) {
                nums1[k--] = nums1[i--];
                continue;
            }
            if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }

        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int arr[] = new int[m + n];
        int i = 0;
        int mm = 0;
        int nn = 0;
        while (mm < m || nn < n) {
            if (mm < m && nn >= n) {
                arr[i] = nums1[mm];
                mm++;
            } else if (nn < n && mm >= m) {
                arr[i] = nums2[nn];
                nn++;
            } else {
                if (nums1[mm] < nums2[nn]) {
                    arr[i] = nums1[mm];
                    mm++;
                } else {
                    arr[i] = nums2[nn];
                    nn++;
                }
            }
            i++;
        }
        for (int k = 0; k < m + n; k++) {
            nums1[k] = arr[k];
        }
    }
}

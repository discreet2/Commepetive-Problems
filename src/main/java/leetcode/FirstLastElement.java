package leetcode;

public class FirstLastElement {
    //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    public static void main(String[] args) {
        FirstLastElement fle = new FirstLastElement();
        int nums[] = {};
        int r[] = fle.searchRange(nums, 2);
        System.out.println(r[0] + "," + r[1]);

    }

    public int[] searchRange(int[] nums, int target) {
        //return search(nums, target, 0, nums.length); recursive
        //iterative
        int l = 0, r = nums.length - 1, mid = 0;
        int res[] = {-1, -1};
        boolean found = false;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                found = true;
                break;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (found) {
            int j = mid;
            for (; j >= 0; j--) {
                if (nums[j] != target) break;
            }
            res[0] = j + 1;
            for (j = mid; j < nums.length; j++) {
                if (nums[j] != target) break;
            }
            res[1] = j - 1;
        }
        return res;
    }

    public int[] search(int[] nums, int target, int start, int end) {
        if (start == end) {
            int res[] = new int[2];
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        int mid = (end - start) / 2;
        if (nums[mid] == target) {
            int res[] = new int[2];
            int i = mid;
            for (; i >= 0; i--) {
                if (nums[i] != target) break;
            }
            res[0] = i + 1;
            for (i = mid; i < nums.length; i++) {
                if (nums[i] != target) break;
            }
            res[1] = i - 1;
            return res;
        } else if (nums[mid] > target) {
            return search(nums, target, start, mid);
        } else {
            return search(nums, target, mid + 1, end);
        }
    }
}

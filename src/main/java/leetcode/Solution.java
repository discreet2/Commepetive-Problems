package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int arr[] = {1,2};
        System.out.println(s.solution(arr));
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        long pairCount = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(A[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(A[i], list);
            } else {
                List<Integer> list = map.get(A[i]);
                list.add(i);
                map.put(A[i], list);
            }
        }
        for (int i = 0; i < A.length; i++) {
            List<Integer> list = map.get(A[i]);
            for (int j : list) {
                if (i < j) pairCount++;
            }
        }
        if (pairCount > 1000000000) return 1000000000;
        else return (int) pairCount;

    }

    /*public String solution(String S) {
        // write your code in Java SE 8
        char str[] = new char[S.length()];
        if (S.length() % 2 == 1) {
            if (S.charAt(S.length() / 2) == '?') {
                str[S.length() / 2] = 'z';
            } else {
                str[S.length() / 2] = S.charAt(S.length() / 2);
            }
        }
        int i = 0, j = S.length() - 1;
        while (i < j) {
            if (S.charAt(i) == S.charAt(j)) {
                if (S.charAt(i) == '?') {
                    str[i] = 'z';
                    str[j] = 'z';
                } else {
                    str[i] = S.charAt(i);
                    str[j] = S.charAt(j);
                }
            } else if (S.charAt(i) == '?') {
                str[i] = S.charAt(j);
                str[j] = S.charAt(j);
            } else if (S.charAt(j) == '?') {
                str[i] = S.charAt(i);
                str[j] = S.charAt(i);
            } else {
                return "NO";
            }
            i++;
            j--;
        }
        return String.valueOf(str);
    }*/

    /*public int solution(int[] A) {
        // write your code in Java SE 8
        int max = Integer.MIN_VALUE;
        int result;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int val = A[i];
            map.put(val, i);
            if (val > max) {
                max = val;
            }
        }
        for (int i = 1; i <= max; i++) {
            if (!map.containsKey(i)) return i;
        }
        if (max > 0) return max + 1;
        else return 1;
    }*/
}

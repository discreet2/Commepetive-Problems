package leetcode;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int arr[] = {5, 2, 1,3,1,4, 6, 7};
        System.out.println(solution.solution2(arr));
    }

    public int solution2(int[] A) {
        int minVal[] = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int minValIndex[] = {-1, -1, -1, -1};
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] < minVal[0]) {
                minVal[3] = minVal[2];
                minVal[2] = minVal[1];
                minVal[1] = minVal[0];
                minValIndex[3] = minValIndex[2];
                minValIndex[2] = minValIndex[1];
                minValIndex[1] = minValIndex[0];

                minVal[0] = A[i];
                minValIndex[0] = i;
            } else if (A[i] < minVal[1]) {
                minVal[3] = minVal[2];
                minVal[2] = minVal[1];
                minValIndex[3] = minValIndex[2];
                minValIndex[2] = minValIndex[1];

                minVal[1] = A[i];
                minValIndex[1] = i;
            } else if (A[i] < minVal[2]) {
                minVal[3] = minVal[2];
                minValIndex[3] = minValIndex[2];
                minVal[2] = A[i];
                minValIndex[2] = i;
            } else if (A[i] < minVal[3]) {
                minVal[3] = A[i];
                minValIndex[3] = i;
            }
        }
        for (int i = 0; i < minVal.length - 1; i++) {
            for (int j = i + 1; j < minVal.length; j++) {
                if (minValIndex[j] != -1 && Math.abs(minValIndex[j] - minValIndex[i]) >= 2) {
                    int val = minVal[i] + minVal[j];
                    if (val < res) {
                        res = val;
                    }
                }
            }
        }
        return res;
    }


    public int solution(int[] A) {
        // write your code in Java SE 8
        int result = Integer.MAX_VALUE;
        int minArr[] = new int[A.length];
        for (int i = 1; i < A.length - 1; i++) {
            for (int j = i + 2; j < A.length - 1; j++) {
                if (result > (A[i] + A[j])) {
                    result = A[i] + A[j];
                }
            }
        }
        return result;
    }

    /*public int solution(String S, int[] C) {
        // write your code in Java SE 8
        int result = 0;
        int max = C[0], costTotal = C[0];
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) != S.charAt(i - 1)) {
                result += costTotal - max;
                costTotal = C[i];
                max = C[i];
            } else {
                costTotal += C[i];
                if (C[i] > max) {
                    max = C[i];
                }
            }
        }
        result += costTotal - max;
        return result;
    }*/

    /*public int solution(String S) {
        // write your code in Java SE 8
        int i = 0, result = 0;

        while (i < S.length() - 1) {
            int fragment = Integer.parseInt(S.substring(i, i + 2));
            if (fragment > result) {
                result = fragment;
            }
            i++;
        }
        return result;
    }*/
}

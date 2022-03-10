package leetcode;

import java.util.Arrays;

//https://leetcode.com/discuss/interview-question/1412987/microsoft-online-assessment-missing-numbers-dice
public class N26Task3 {

    public int[] solution(int[] A, int F, int M) {
        // write your code in Java SE 8um
        int memorableSum = 0;
        int totalRolls = A.length + F;
        int totalSum = totalRolls * M;
        for (int i = 0; i < A.length; i++) {
            memorableSum += A[i];
        }
        int forgetAbleSum = totalSum - memorableSum;
        if (forgetAbleSum < 0 || (forgetAbleSum / F > 6)) return new int[]{0};

        int averageFVal = forgetAbleSum / F;
        int[] ans = new int[F];
        for (int x = 0; x < F; x++) {
            if (x == F - 1) {
                ans[x] = forgetAbleSum;
                continue;
            }
            ans[x] = averageFVal;
            forgetAbleSum -= averageFVal;
        }
        return ans;
    }


    public static void main(String[] args) {
        N26Task3 task3 = new N26Task3();
        int nums[] = {6, 1};
        System.out.println(Arrays.toString(task3.solution(nums, 1, 3)));
    }
}

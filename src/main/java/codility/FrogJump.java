package codility;

import java.util.Arrays;

//https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
//https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
public class FrogJump {
    public static void main(String[] args) {
        FrogJump frogJump = new FrogJump();
        System.out.println(frogJump.solution(10, 85, 30));
        System.out.println(frogJump.solution(new int[]{2, 3, 1, 5}));
    }

    public int solution(int X, int Y, int D) {
        int result = ((Y - X) / D) + ((Y - X) % D == 0 ? 0 : 1);
        return result;
    }

    public int solution(int[] A) {
        Arrays.sort(A);
        for (int i = 1; i <= A.length; i++) {
            if (i != A[i - 1]) return i;
        }
        return A.length + 1;
    }
}

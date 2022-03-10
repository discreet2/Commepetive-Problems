package codility;
//https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
public class TapeEquilibrium {
    public int solution(int[] A) {
        long sumLeft = A[0], sumRight = 0;
        for (int i = 1; i < A.length; i++) {
            sumRight += A[i];
        }
        int ans = (int) Math.abs(sumLeft - sumRight);
        for (int P = 1; P < A.length - 1; P++) {
            sumLeft += A[P];
            sumRight -= A[P];
            ans = (int) Math.min(ans, Math.abs(sumLeft - sumRight));
        }
        return ans;
    }
}

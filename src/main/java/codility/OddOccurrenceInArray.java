package codility;

import java.util.Arrays;
//https://www.geeksforgeeks.org/find-the-number-occurring-odd-number-of-times/
public class OddOccurrenceInArray {
    public int solution(int[] A) {
        Arrays.sort(A);
        int i = 0;
        while (i < A.length) {
            if (i + 1 >= A.length) return A[i];
            if (A[i] != A[i + 1]) return A[i];
            i += 2;
        }
        return 0;
    }
}

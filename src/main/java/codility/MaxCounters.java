package codility;


import java.util.Arrays;

//https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
public class MaxCounters {
    public static void main(String[] args) {
        MaxCounters maxCounters = new MaxCounters();
        int arr[] = {3, 4, 4, 6, 1, 4, 4};
        System.out.println(Arrays.toString(maxCounters.solution(5, arr)));
    }

    public int[] solution(int N, int[] A) {
        int result[] = new int[N];
        int currentMax = 0, lastFilledMax = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == N + 1) {
                lastFilledMax = currentMax;
            } else {
                if (result[A[i] - 1] < lastFilledMax) {
                    result[A[i] - 1] = lastFilledMax + 1;
                } else {
                    result[A[i] - 1]++;
                }
                if (result[A[i] - 1] > currentMax) {
                    currentMax = result[A[i] - 1];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            result[i] = Math.max(result[i], lastFilledMax);
        }
        return result;
    }
}

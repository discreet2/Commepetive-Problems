package codility;

//https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
public class CyclicRotation {

    public int[] solution(int[] A, int K) {
        if (A.length == K || K == 0 || A.length == 0 || K % A.length == 0) return A;
        int res[] = new int[A.length];
        if (K > A.length) {
            K = K % A.length;
        }
        for (int i = 0; i < A.length; i++) {
            int index = (A.length - K + i) % A.length;
            res[i] = A[index];
        }
        return res;
    }
}

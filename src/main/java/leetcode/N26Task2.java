package leetcode;

public class N26Task2 {

    //https://stackoverflow.com/questions/66406257/c-sharp-codility-question-number-of-castles-how-to-solve-it
    //https://www.answersaccess.com/ExpertAnswers/let-p-q-denote-a-group-of-consecutive-segments-from-p-to-q-inclusive-such-that-ospsq-sn-1-segments-p
    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length == 1) return 0;
        int valleyCount = 0;
        int prevSegmentHeight = A[0];
        for (int i = 1; i < A.length; i++) {

            int nextSegmentHeight;
            if (i == A.length - 1) {
                nextSegmentHeight = prevSegmentHeight;
            } else {
                nextSegmentHeight = A[i + 1];
            }
            //check for hill
            if (A[i] > prevSegmentHeight && prevSegmentHeight == nextSegmentHeight) {
                System.out.println("hill prev: " + prevSegmentHeight + " curr: " + A[i] + " next: " + nextSegmentHeight);
                valleyCount++;
            }
            //check for valley
            if (i == 1) {
                prevSegmentHeight = nextSegmentHeight;
            }
            if ((A[i] < prevSegmentHeight ) && prevSegmentHeight == nextSegmentHeight) {
                System.out.println("valley prev: " + prevSegmentHeight + " curr: " + A[i] + " next: " + nextSegmentHeight);
                valleyCount++;
            }
            if (A[i] != prevSegmentHeight && A[i] != nextSegmentHeight)
                prevSegmentHeight = A[i];
        }
        return valleyCount;
    }

    public static void main(String[] args) {
        N26Task2 task2 = new N26Task2();
        //int nums[] = {-3, -3};
        // System.out.println(task2.solution(nums));
        int nums1[] = {2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5};
        System.out.println(task2.solution(nums1));
    }
}

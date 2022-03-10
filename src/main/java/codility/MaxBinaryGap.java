package codility;

//https://leetcode.com/problems/binary-gap/
public class MaxBinaryGap {
    public int solution(int N) {
        // write your code in Java SE 8
        String binaryString = Integer.toBinaryString(N);
        System.out.println(binaryString);
        int first = -1, second = -1;
        char lastBit = '0';
        int result = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            char ch = binaryString.charAt(i);
            if (ch == '1' && lastBit != '1') {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                }
                if (first >= 0 && second > 0) {
                    if ((second - first - 1) > result) {
                        result = second - first - 1;
                    }
                    first = i;
                    second = -1;
                }
            } else if (ch == '1' && lastBit == '1') {
                first = i;
            }
            lastBit = ch;
        }
        return result;
    }
}

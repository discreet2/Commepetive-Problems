package leetcode;

//https://leetcode.com/problems/reverse-integer/
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(563847412));
    }

    public int reverse(int x) {
        int sign = 1;
        if (x < 0) {
            sign = -1;
            x = x * sign;
        }
        int backwardSum = 0;
        while (x > 0) {
            if (sign == 1 && backwardSum > Integer.MAX_VALUE / 10) return 0;
            else if (sign < 0 && backwardSum * sign < Integer.MIN_VALUE / 10) return 0;
            backwardSum = 10 * backwardSum + x % 10;
            x = x / 10;
        }
        return backwardSum * sign;
    }
}

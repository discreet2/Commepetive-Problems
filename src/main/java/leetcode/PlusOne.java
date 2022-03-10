package leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/plus-one/
public class PlusOne {
    public static void main(String[] args) {
        PlusOne pn = new PlusOne();
        System.out.println(Arrays.toString(pn.plusOne(new int[]{1,2,9})));
    }

    public int[] plusOne(int[] digits) {
        int length = digits.length + 1, carry = 1;

        int res[] = new int[length];
        int i = length - 1, j = digits.length - 1;
        while (i >= 0) {
            if (j < 0) {
                res[i--] = carry;
                break;
            }
            int sum = digits[j--] + carry;
            res[i--] = sum % 10;
            carry = sum / 10;
        }
        if (res[0] == 0) {
            return Arrays.copyOfRange(res, 1, length);
        }
        return res;
    }
}

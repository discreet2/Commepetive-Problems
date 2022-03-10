package leetcode;

public class Atoi {
    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        System.out.println(atoi.myAtoi("91283472332"));
    }

    public int myAtoi(String s) {
        int sign = 1, i = 0;
        while (i < s.length() && Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }
        int result = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = getDigit(s.charAt(i));
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }
        return result * sign;
    }

    private int getDigit(char ch) {
        return ch - '0';
    }
}

package leetcode;

public class IntToRoman {
    //https://leetcode.com/problems/integer-to-roman/
    //LeetCode 12
    public static void main(String[] args) {
        IntToRoman intToRoman=new IntToRoman();
        System.out.println(intToRoman.intToRoman(1994));
    }

    public String intToRoman(int num) {
        int[] romanValue = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLiteral = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL",
                "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < romanValue.length; i++) {
            if (romanValue[i] <= num) {
                sb.append(romanLiteral[i]);
                num -= romanValue[i];
                i--;
            }
        }
        return sb.toString();
    }
}

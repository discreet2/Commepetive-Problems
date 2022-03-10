package leetcode;

//https://leetcode.com/problems/palindrome-number/
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().isPalindrome(123));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int backwardSum = 0, originalMun = x;
        while (originalMun > 0) {
            backwardSum = backwardSum * 10 + originalMun % 10;
            originalMun = originalMun / 10;
        }
        System.out.println(backwardSum);
        return backwardSum == x;
    }
}

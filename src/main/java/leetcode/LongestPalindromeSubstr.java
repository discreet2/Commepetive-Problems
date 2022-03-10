package leetcode;

public class LongestPalindromeSubstr {
    //https://leetcode.com/problems/longest-palindromic-substring/
    public static void main(String[] args) {
       main(null);
    }

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                //if(i==j) continue;
                System.out.println("i:" + i + " j:" + j);
                System.out.println(s.substring(i, j));
                throw new Error();
            }
        }
        return "";
    }
}

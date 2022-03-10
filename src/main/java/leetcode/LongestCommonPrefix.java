package leetcode;

public class LongestCommonPrefix {
    //https://leetcode.com/problems/longest-common-prefix/submissions/
    public static void main(String[] args) {
        String strs[] = {"dog","racecar","car"};
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        System.out.println(lcp.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLength = Math.min(minLength, strs[i].length());
        }
        System.out.println(minLength);
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < minLength; i++) {
            char ch = strs[0].charAt(i);
            boolean matched = true;
            for (int j = 1; j < strs.length; j++) {
                if (ch != strs[j].charAt(i)) {
                    matched = false;
                    break;
                }
            }
            if (matched) {
                sb.append(ch);
            } else {
                break;
            }
        }
        return sb.toString();

    }
}

package leetcode;

public class StrStr {
    //https://leetcode.com/problems/implement-strstr/
    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        System.out.println(strStr.strStr("baa", "a"));
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        if (haystack == null || haystack.length() == 0) return -1;
        int needleLength = needle.length(), haystackLength = haystack.length();
        int currentNeedleLength = 0, i = 0;
        while (currentNeedleLength < needleLength && i < haystackLength) {
            if (haystack.charAt(i) == needle.charAt(currentNeedleLength)) {
                currentNeedleLength++;
                i++;
            } else {
                i = i - currentNeedleLength + 1;
                currentNeedleLength = 0;
            }
        }
        return (currentNeedleLength == needleLength) ? (i - needleLength) : -1;
    }
}

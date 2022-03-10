package leetcode;

public class StringCompression {
    //https://leetcode.com/problems/string-compression/
    //LeetCode 443
    public static void main(String[] args) {
        StringCompression m = new StringCompression();
       // char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        //char[] chars = {'a'};
        //char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        char[] chars = {'a','a','a','b','b','a','a'};
        System.out.println(m.compress(chars));
    }

    public int compress(char[] chars) {
        char groupChar = chars[0];
        int currentGroupCount = 1;
        int length = 0;
        for (int i = 1; i < chars.length; i++) {
            if (groupChar == chars[i]) {
                currentGroupCount++;
            } else {
                chars[length++] = groupChar;
                if (currentGroupCount > 1) {
                    String g = Integer.toString(currentGroupCount);
                    for (char ch : g.toCharArray()) {
                        chars[length++] = ch;
                    }
                }
                groupChar = chars[i];
                currentGroupCount = 1;
            }
        }
        chars[length++] = groupChar;
        if (currentGroupCount > 1) {
            String g = Integer.toString(currentGroupCount);
            for (char ch : g.toCharArray()) {
                chars[length++] = ch;
            }
        }

        System.out.println(chars);
        return length;
    }

}

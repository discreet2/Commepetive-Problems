package leetcode;

public class ReverseWords {
    //https://leetcode.com/problems/reverse-words-in-a-string/
    public static void main(String[] args) {
        ReverseWords words = new ReverseWords();
        System.out.println(words.reverseWords("a good   example"));
    }

    public String reverseWords(String s) {
        String a[] = s.split(" ");

        StringBuilder b = new StringBuilder();

        for(int i=a.length-1; i>=0; i--) {
            if(!a[i].isBlank()) {
                b.append(a[i]);
                if(i!=0)
                    b.append(" ");
            }

        }
        return b.toString();
    }
}

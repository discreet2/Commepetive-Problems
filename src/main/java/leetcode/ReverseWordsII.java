package leetcode;

public class ReverseWordsII {
    //https://aaronice.gitbook.io/lintcode/string/reverse-words-in-a-string-ii
    public static void main(String[] args) {
        ReverseWordsII wordsII = new ReverseWordsII();
        char arrs[] = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        wordsII.reverseWords(arrs);
    }

    public void reverseWords(char[] chars) {
        reverse(chars, 0, chars.length - 1);
        print(chars);
        System.out.println();
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, j, i - 1);
                j = i + 1;
                print(chars);
                System.out.println();
            }
        }
        reverse(chars, j, chars.length - 1);
        print(chars);
    }

    public void reverse(char arr[], int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public void print(char arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

}

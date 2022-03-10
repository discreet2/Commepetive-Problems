package marketing;

public class Task3 {
    public static void main(String[] args) {
        Task3 task3 = new Task3();
        System.out.println(task3.solution("00011100"));
        System.out.println(task3.solution("1111010101111"));
        System.out.println(task3.solution("111"));
    }

    public int solution(String S) {
        int operationCount = 0;
        int leadingZeroCount = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '0') leadingZeroCount++;
            else break;
        }
        int l = S.length() - 1;
        while (l >= leadingZeroCount) {
            char ch = S.charAt(l);
            if (ch == '0') {
                operationCount++;
                l--;
            } else {
                if (l == leadingZeroCount) {
                    operationCount++;
                } else {
                    operationCount += 2;
                }
                l--;
            }
        }
        return operationCount;
    }
}

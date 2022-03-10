package leetcode;

public class ValidNumber {

    //https://leetcode.com/problems/valid-number/
    public static void main(String[] args) {
        ValidNumber validNumber = new ValidNumber();
        System.out.println(validNumber.isNumber("46.e3"));
    }

    public boolean isNumber(String s) {
        int dotCount = 0, eCount = 0, i = 0;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            i++;
        }
        for (; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.toLowerCase(ch) == 'e') {
                if (i - 1 < 0 || i + 1 >= s.length()) return false;
                else if (!Character.isDigit(s.charAt(i - 1)) && s.charAt(i - 1) != '.') return false;
                else if (s.charAt(i + 1) != '-' && s.charAt(i + 1) != '+' && !Character.isDigit(s.charAt(i + 1)))
                    return false;
                else eCount++;
            } else if (ch == '.') {
                if (eCount > 0) return false;
                else if (i - 1 >= 0 && Character.isDigit(s.charAt(i - 1))) {
                    dotCount++;
                    continue;
                } else if (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    dotCount++;
                    continue;
                } else {
                    return false;
                }
            } else if (ch == '-' || ch == '+') {
                if (i - 1 < 0 || i + 1 >= s.length()) return false;
                else if (Character.toLowerCase(s.charAt(i - 1)) != 'e' || !Character.isDigit(s.charAt(i + 1)))
                    return false;
            } else if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return dotCount <= 1 && eCount <= 1;
    }

    public boolean isNumber2(String s) {
        if(s==null)
            return false;
        boolean seenDigit=false;
        boolean seenExponent = false;
        boolean seenDot = false;
        for(int i=0;i<s.length();i++) {
            char curr = s.charAt(i);
            if(Character.isDigit(curr)) {
                seenDigit=true;
            }else if(curr=='+' || curr=='-') {
                if(i>0 && s.charAt(i-1)!='e' && s.charAt(i-1)!='E')
                    return false;
            }else if(curr=='e'||curr=='E') {
                if(seenExponent || !seenDigit)
                    return false;
                seenExponent=true;
                seenDigit=false;
            }else if(curr=='.') {
                if(seenDot ||seenExponent)
                    return false;
                seenDot=true;
            }else {
                return false;
            }
        }
        return seenDigit;
    }
}

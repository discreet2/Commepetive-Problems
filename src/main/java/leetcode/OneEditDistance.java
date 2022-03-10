package leetcode;

public class OneEditDistance {
    public static void main(String[] args) {
        OneEditDistance oneEditDistance = new OneEditDistance();
        System.out.println(oneEditDistance.isOneEditDistance("ba", "ab"));
    }

    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) return false;
        int m = s.length();
        int n = t.length();
        if (m > n) {
            return isOneEditDistance(t, s);
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (m == n) {
                    return s.substring(i+1).equals(t.substring(i+1));
                }
                return s.substring(i).equals(t.substring(i + 1));
            }
        }
        return m != n;
    }

    public boolean isOneEditDistance2(String s, String t) {
        if (s.equals(t)) return false;
        if (Math.abs(s.length() - t.length()) > 1) return false;
        int diffCount = 0;
        int si = 0, ti = 0;
        if (s.length() > t.length()) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(si) == t.charAt(ti)) {
                    si++;
                    ti++;
                } else {
                    si++;
                    diffCount++;
                }
            }
        } else if (s.length() == t.length()) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) diffCount++;
            }

        } else {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(si) == t.charAt(ti)) {
                    si++;
                    ti++;
                } else {
                    ti++;
                    diffCount++;
                }
            }
        }
        return diffCount <= 1;
    }
}

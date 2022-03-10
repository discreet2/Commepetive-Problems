package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
//https://www.youtube.com/watch?v=wiGpQwVHdE0
public class LongestSubstrWithoutRepeat {
    public static void main(String[] args) {
        LongestSubstrWithoutRepeat lswr = new LongestSubstrWithoutRepeat();
        System.out.println(lswr.lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        Set<Character> set = new HashSet<>();
        int result = 0;
        for (int r = 0; r < s.length(); r++) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            result = Math.max(result, (r - l + 1));
        }
        return result;
    }

    public int lengthOfLongestSubstring2(String s) {
        int currentSubStrLength = 0, maxSubstrLength = 0;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            currentSubStrLength = 0;
            if (s.length() - i <= maxSubstrLength) break;
            for (int j = i; j < s.length(); j++) {
                if (map.containsKey(s.charAt(j))) {
                    if (currentSubStrLength > maxSubstrLength) {
                        maxSubstrLength = currentSubStrLength;
                    }
                    currentSubStrLength = 1;
                } else {
                    map.put(s.charAt(j), s.charAt(j));
                    currentSubStrLength++;
                }

            }

            map.clear();
            if (currentSubStrLength > maxSubstrLength) {
                maxSubstrLength = currentSubStrLength;
            }
        }
        return maxSubstrLength;
    }
}

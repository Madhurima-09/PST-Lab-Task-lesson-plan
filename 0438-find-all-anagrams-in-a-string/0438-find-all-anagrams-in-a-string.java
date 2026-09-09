import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();

        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        int sLen = s.length();
        int pLen = p.length();

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Populate frequency array for p and the first window of s
        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        // Check first window
        if (Arrays.equals(pCount, sCount)) {
            result.add(0);
        }

        // Slide window across string s
        for (int i = pLen; i < sLen; i++) {
            // Add right character to window
            sCount[s.charAt(i) - 'a']++;

            // Remove left character from window
            sCount[s.charAt(i - pLen) - 'a']--;

            // Check if current window matches target frequency
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - pLen + 1);
            }
        }

        return result;
    }
}
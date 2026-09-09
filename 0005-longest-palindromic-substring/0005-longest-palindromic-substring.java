public class Solution {
    private int start = 0;
    private int maxLength = 0;

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            // Expand around single character center (Odd length)
            expandAroundCenter(s, i, i);
            // Expand around character gap center (Even length)
            expandAroundCenter(s, i, i + 1);
        }

        return s.substring(start, start + maxLength);
    }

    private void expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // Calculate valid length after loop terminates (pointers step 1 index past boundary)
        int length = right - left - 1;
        
        if (length > maxLength) {
            maxLength = length;
            start = left + 1; // Correct start pointer index
        }
    }
}
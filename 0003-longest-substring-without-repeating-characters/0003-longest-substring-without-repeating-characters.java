import java.util.Arrays;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // Store last seen index of ASCII characters (initialized to -1)
        int[] lastPos = new int[256];
        Arrays.fill(lastPos, -1);

        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If character seen inside current window, move left boundary past it
            if (lastPos[currentChar] >= left) {
                left = lastPos[currentChar] + 1;
            }

            // Update character's last seen index
            lastPos[currentChar] = right;

            // Calculate max window length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
public class Solution {
    public boolean rotateString(String s, String goal) {
        if (s == null || goal == null) {
            return false;
        }
        
        // Rotations must preserve equal lengths
        if (s.length() != goal.length()) {
            return false;
        }

        // Check if goal exists as a contiguous substring in s + s
        String doubled = s + s;
        return doubled.contains(goal);
    }
}
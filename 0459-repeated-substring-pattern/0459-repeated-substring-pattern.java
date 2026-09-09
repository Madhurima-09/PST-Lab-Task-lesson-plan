public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }
        
        String doubled = s + s;
        // Search inside doubled excluding first and last characters
        return doubled.substring(1, doubled.length() - 1).contains(s);
    }
}
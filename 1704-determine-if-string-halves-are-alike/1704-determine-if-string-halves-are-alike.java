import java.util.Set;

public class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int mid = n / 2;
        
        // Define all vowels (both uppercase and lowercase)
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        
        int countA = 0;
        int countB = 0;
        
        for (int i = 0; i < mid; i++) {
            // Check first half
            if (vowels.contains(s.charAt(i))) {
                countA++;
            }
            // Check second half
            if (vowels.contains(s.charAt(i + mid))) {
                countB++;
            }
        }
        
        return countA == countB;
    }
}
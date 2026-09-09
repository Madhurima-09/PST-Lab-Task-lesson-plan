import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<String>();
        int n = words.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Skip comparing string against itself
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break; // Move to next word once confirmed as a substring
                }
            }
        }

        return result;
    }
}
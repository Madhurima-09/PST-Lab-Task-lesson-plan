import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<String>();

        for (int i = 0; i < words.length; i++) {
            if (matches(words[i], pattern)) {
                result.add(words[i]);
            }
        }

        return result;
    }

    private boolean matches(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }

        int[] mapPtoW = new int[256];
        int[] mapWtoP = new int[256];

        Arrays.fill(mapPtoW, -1);
        Arrays.fill(mapWtoP, -1);

        for (int i = 0; i < word.length(); i++) {
            char pChar = pattern.charAt(i);
            char wChar = word.charAt(i);

            // Check if existing mappings match current characters
            if (mapPtoW[pChar] != -1 && mapPtoW[pChar] != wChar) {
                return false;
            }
            if (mapWtoP[wChar] != -1 && mapWtoP[wChar] != pChar) {
                return false;
            }

            // Establish mapping
            mapPtoW[pChar] = wChar;
            mapWtoP[wChar] = pChar;
        }

        return true;
    }
}
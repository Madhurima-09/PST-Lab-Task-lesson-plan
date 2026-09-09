public class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        // 1. Build 2D Prefix Sum Array (1-indexed for boundary safety)
        int[][] pref = new int[m + 1][n + 1];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                pref[r + 1][c + 1] = mat[r][c] 
                                   + pref[r][c + 1] 
                                   + pref[r + 1][c] 
                                   - pref[r][c];
            }
        }
        
        int[][] answer = new int[m][n];
        
        // 2. Query prefix sum for each cell (i, j)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Determine valid boundary indices (0-indexed for mat)
                int r1 = Math.max(0, i - k);
                int r2 = Math.min(m - 1, i + k);
                int c1 = Math.max(0, j - k);
                int c2 = Math.min(n - 1, j + k);
                
                // Convert to 1-indexed for pref array
                answer[i][j] = pref[r2 + 1][c2 + 1] 
                             - pref[r1][c2 + 1] 
                             - pref[r2 + 1][c1] 
                             + pref[r1][c1];
            }
        }
        
        return answer;
    }
}
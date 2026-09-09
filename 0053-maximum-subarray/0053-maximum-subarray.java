public class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentMax = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // Either extend the previous subarray or start a new subarray at current element
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            // Track the global maximum sum found so far
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        
        return maxSoFar;
    }
}
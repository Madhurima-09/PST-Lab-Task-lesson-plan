public class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        
        int maxSoFar = nums[0];
        int currentMax = 0;
        
        int minSoFar = nums[0];
        int currentMin = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            totalSum += num;
            
            // Standard Kadane's for Maximum Subarray Sum
            currentMax = Math.max(num, currentMax + num);
            maxSoFar = Math.max(maxSoFar, currentMax);
            
            // Inverted Kadane's for Minimum Subarray Sum
            currentMin = Math.min(num, currentMin + num);
            minSoFar = Math.min(minSoFar, currentMin);
        }
        
        // Edge case: If all elements are negative, maxSoFar will be negative.
        // totalSum - minSoFar would return 0 (an empty subarray), so return maxSoFar directly.
        if (maxSoFar < 0) {
            return maxSoFar;
        }
        
        // Return the maximum of the non-wrapping case and wrapping case
        return Math.max(maxSoFar, totalSum - minSoFar);
    }
}
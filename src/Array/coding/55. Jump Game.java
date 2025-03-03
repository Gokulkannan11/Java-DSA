class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0; // Stores the farthest index we can reach
        
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false; // If we are stuck at some index, return false
            }
            maxReach = Math.max(maxReach, i + nums[i]); // Update max reachable index
            
            if (maxReach >= nums.length - 1) {
                return true; // If we reach the last index, return true
            }
        }
        
        return false; // If loop finishes without reaching the last index
    }
}

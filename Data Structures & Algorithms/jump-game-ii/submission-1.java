// class Solution {
//     public int jump(int[] nums) {
//         return compute(nums, 0);
//     }

//     private int compute(int[] nums, int ind) {
//         // Base case: If we reached or crossed the destination, 0 more jumps needed
//         if (ind >= nums.length - 1) {
//             return 0;
//         }

//         int minJumps = Integer.MAX_VALUE;

//         // Explore all possible jump lengths from the current index
//         for (int i = 1; i <= nums[ind]; i++) {
//             int nextIndex = ind + i;
            
//             int jumps = compute(nums, nextIndex);
            
//             // If the subproblem was reachable, add 1 to count this jump
//             if (jumps != Integer.MAX_VALUE) {
//                 minJumps = Math.min(minJumps, jumps + 1);
//             }
//         }

//         return minJumps;
//     }
// }


class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1); // -1 means uncomputed
        return compute(nums, 0, dp);
    }

    private int compute(int[] nums, int ind, int[] dp) {
        if (ind >= nums.length - 1) return 0;
        
        // Return cached result if already calculated
        if (dp[ind] != -1) return dp[ind];

        int minJumps = Integer.MAX_VALUE;

        for (int i = 1; i <= nums[ind]; i++) {
            int jumps = compute(nums, ind + i, dp);
            if (jumps != Integer.MAX_VALUE) {
                minJumps = Math.min(minJumps, jumps + 1);
            }
        }

        // Cache the result before returning
        return dp[ind] = minJumps;
    }
}

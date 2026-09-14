class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int sum=0;
        int minWinSize=Integer.MAX_VALUE;
        int left=0;

        for(int right=0;right<n;right++){
            sum+=nums[right];

            while(sum>=target){
                minWinSize=Math.min(minWinSize,right-left+1);


                sum-=nums[left];
                left++;
            }    
        }
        return minWinSize==Integer.MAX_VALUE?0:minWinSize;
    }
}
//sliding window
//shortest/minimum
//valid condition sum>=target
//return 0 if no subarray found

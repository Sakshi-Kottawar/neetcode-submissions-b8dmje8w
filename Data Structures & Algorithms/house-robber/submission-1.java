class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return compute(nums,n-1,dp);
        
    }

    private int compute(int[] nums,int ind,int[] dp){
        if(ind<0)return 0;
        if(ind==0)return dp[ind]=nums[ind];
        if(dp[ind]!=-1)return dp[ind];
        int pick=nums[ind]+compute(nums,ind-2,dp);
        int notPick=compute(nums,ind-1,dp);
        return dp[ind]=Math.max(pick,notPick);
    }
}

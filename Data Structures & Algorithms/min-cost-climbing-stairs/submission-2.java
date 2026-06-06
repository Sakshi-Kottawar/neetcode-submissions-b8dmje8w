class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(compute(cost, n - 1,dp), compute(cost, n - 2,dp));
    }

    private int compute(int[] cost,int ind,int[]dp){
        if(ind<0) return 0;
        if(ind==0 || ind==1){
            return dp[ind]=cost[ind];
        } 
        if(dp[ind]!=-1)return dp[ind];
        int left=compute(cost,ind-1,dp);
        int right=compute(cost,ind-2,dp);

        return dp[ind]= cost[ind] + Math.min(left,right);
    }
}

;
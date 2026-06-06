class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=cost[0];
        dp[1]=cost[1];

        for(int i=2;i<n;i++){
            int left=dp[i-1];
            int right=dp[i-2];

           dp[i]= cost[i] + Math.min(left,right);
        }



        return Math.min(dp[n-1], dp[n-2]);
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
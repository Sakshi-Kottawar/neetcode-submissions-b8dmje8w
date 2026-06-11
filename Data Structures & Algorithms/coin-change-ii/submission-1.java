class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return compute(coins,n-1,amount,dp);
    }
    int compute(int[] coins,int i,int amount,int dp[][]){
        if(amount==0)return 1;
        if(i==0)
            return dp[i][amount]=(amount%coins[0]==0)?1:0;
        if(dp[i][amount]!=-1)return dp[i][amount];

        int notpick=compute(coins,i-1,amount,dp);
        int pick=0;
        if(coins[i]<=amount)
            pick=compute(coins,i,amount-coins[i],dp);

        return dp[i][amount]=pick+notpick;
    }
}

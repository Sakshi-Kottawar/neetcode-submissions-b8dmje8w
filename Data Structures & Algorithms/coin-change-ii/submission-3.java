class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        int prev[]=new int[amount+1];
        int curr[]=new int[amount+1];
        prev[0]=1;
        curr[0]=1;
        for(int j=0;j<=amount;j++){
            prev[j]=(j%coins[0]==0)?1:0;
        }
        

        for(int i=1;i<n;i++){
            // curr[0]=1;
            for(int j=1;j<=amount;j++){
                int notpick=prev[j];
                int pick=0;
                if(coins[i]<=j)
                    pick=curr[j-coins[i]];

                curr[j]=pick+notpick;
            }
            prev=curr.clone();
        }

        return prev[amount];
    }
}

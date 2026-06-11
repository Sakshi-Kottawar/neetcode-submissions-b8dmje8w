class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int dp[][] = new int[m+1][n+1];

        for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
                if(i==0|| j==0)dp[i][j]=0;
           }
        }

        for(int i=1;i<=m;i++){
           for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                     dp[i][j]=1+dp[i-1][j-1];
                }else{
                     dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
           }
        }
        return dp[m][n];

    }

    private int compute(String s1,String s2,int i,int j,int dp[][]){
        if(i<0 || j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=1+compute(s1,s2,i-1,j-1,dp);
        }else{
            return dp[i][j]=Math.max(compute(s1,s2,i-1,j,dp),compute(s1,s2,i,j-1,dp));
        }
    }
}

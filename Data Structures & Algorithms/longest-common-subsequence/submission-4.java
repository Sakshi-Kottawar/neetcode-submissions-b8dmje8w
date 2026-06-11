class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int dp[][] = new int[m][n];


        for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
                if(text1.charAt(i)==text2.charAt(j)){
                     int value=(i > 0 && j > 0) ?dp[i-1][j-1]:0;
                     dp[i][j]=1+value;
                }else{
                    int upValue = (i > 0) ? dp[i - 1][j] : 0;
                    int leftValue = (j > 0) ? dp[i][j - 1] : 0;
                    dp[i][j] = Math.max(upValue, leftValue);
                }
           }
        }
        return dp[m-1][n-1];

    }
}

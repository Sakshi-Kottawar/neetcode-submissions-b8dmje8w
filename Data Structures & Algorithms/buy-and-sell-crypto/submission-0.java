class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] postFix=new int[n];
        postFix[n-1]=prices[n-1];
        for(int i=n-2;i>=0;i--){
            postFix[i]=Math.max(postFix[i+1],prices[i]);
        }
        int max=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            max=Math.max(max,postFix[i]-prices[i]);
        }
        return max;
    }
}

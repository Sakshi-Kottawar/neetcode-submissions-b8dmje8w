class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0]; 
        int[] tmp=new int[n-1];
        int[] tmp2=new int[n-1];
        for(int i=1,k=0;i<n;i++,k++){
            tmp[k]=nums[i];
        }
        for(int i=0;i<n-1;i++){
            tmp2[i]=nums[i];
        }
        int[] dp=new int[n+1];
        int[] dp1=new int[n+1];
        Arrays.fill(dp,-1);
        Arrays.fill(dp1,-1);

        return Math.max(compute(tmp,tmp.length-1,dp),compute(tmp2,tmp2.length-1,dp1));
    }

    private int compute(int[] nums,int i,int[] dp){
        if(i<0)return 0;
        if(i==0)return dp[i]=nums[0];
        if(dp[i]!=-1)return dp[i];
        int pick=nums[i]+compute(nums,i-2,dp);
        int notpick=compute(nums,i-1,dp);

        return dp[i]=Math.max(pick,notpick);
    }
}

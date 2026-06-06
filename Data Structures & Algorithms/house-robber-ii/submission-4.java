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
        int[] dp=new int[n-1];
        int[] dp1=new int[n-1];
        Arrays.fill(dp,-1);
        Arrays.fill(dp1,-1);

        return Math.max(compute1(tmp,dp),compute1(tmp2,dp1));
    }

    // private int compute(int[] nums,int i,int[] dp){
    //     if(i<0)return 0;
    //     if(i==0)return dp[i]=nums[0];
    //     if(dp[i]!=-1)return dp[i];
    //     int pick=nums[i]+compute(nums,i-2,dp);
    //     int notpick=compute(nums,i-1,dp);

    //     return dp[i]=Math.max(pick,notpick);
    // }

    private int compute1(int[] nums,int[] dp){
        
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            int pick=nums[i];
            if(i>1)
                pick+=dp[i-2];
            int notpick=dp[i-1];

             dp[i]=Math.max(pick,notpick);
        }
        return dp[dp.length-1];
    }
}

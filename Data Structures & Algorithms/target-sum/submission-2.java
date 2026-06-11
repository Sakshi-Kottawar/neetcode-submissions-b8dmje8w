// s1-s2=D
// s1+s2=Total
// s1=total-s2;
// total-2s2=D;total-D/2=s2;
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum<target)return 0;
        if((sum-target)%2!=0)return 0;
        int subsetSum=(sum-target)/2;
        int n=nums.length;
        return count(nums,n-1,subsetSum);
    }
    private int count(int[] nums, int i,int sum){
        // if(nums[0]==sum)return 1;
        if(i<0)return (sum==0)?1:0;
        
        int take=0;
        if(nums[i]<=sum)
            take=count(nums,i-1,sum-nums[i]);
        int nottake=count(nums,i-1,sum);
        return take+nottake;

    }
}

class Solution {
    public boolean canJump(int[] nums) {
        int r=0;
        int n=nums.length;
        if(nums.length==1)return true;
        for(int i=0;i<n;i++){
            if(nums[i]==0 && r<=i){
                return false;
            }
            r=Math.max(r,nums[i]+i);
            if(r>=n-1){
                return true;
            }
        }
        return false;
        
    }
   
}

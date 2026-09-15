class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;

        if(nums[0]<=nums[n-1]){
            return nums[0];
        }

        int res=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]<nums[0] && nums[mid]<=nums[n-1]){
                

                res=mid;
                high=mid-1;
            }else if(nums[mid]>=nums[0] && nums[mid]>nums[n-1]){
                low=mid+1;
            }else{

            }
        }

        return nums[res];
    }
}

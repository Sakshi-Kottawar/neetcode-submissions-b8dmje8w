class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;

       
        int res=nums[0];
        while(low<=high){
            int mid=low+(high-low)/2;
            if (nums[mid] > nums[high]) {
                // Minimum is on the right
                low = mid + 1;
            } else {
                // nums[mid] could be the minimum
                res = Math.min(res,nums[mid]);
                high = mid - 1;
            }
        }

        return res;
    }
}

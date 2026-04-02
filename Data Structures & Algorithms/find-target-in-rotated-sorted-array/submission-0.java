class Solution {
    public int search(int[] nums, int target) {
       int low=findMin(nums);
       int a=binarySearch(nums,low,nums.length-1,target);
       int b=binarySearch(nums,0,low-1,target);
       return a==-1?b:a;
        // return low;
    }

    private int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        while(low<high){
            if(nums[low]<=nums[high])return low;

            int mid=low+(high-low)/2;

            if(nums[mid]>=nums[low]){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return low;
    }

    private int binarySearch(int []nums,int low,int high,int target){
        while(low <= high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}

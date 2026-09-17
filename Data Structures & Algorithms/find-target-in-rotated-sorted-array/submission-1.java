class Solution {
    public int search(int[] nums, int target) {
       int low=findMin(nums);
       int a=binarySearch(nums,low,nums.length-1,target);
       int b=binarySearch(nums,0,low-1,target);
       return a==-1?b:a;
        // return low;
    }

    public int findMin(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;

       
        int res=nums[0];
        int minIndex=0;

        while(low<=high){
            int mid=low+(high-low)/2;
            if (nums[mid] > nums[high]) {
                // Minimum is on the right
                low = mid + 1;
            } else {
                // nums[mid] could be the minimum
                if(nums[mid]<res){
                    minIndex=mid;;
                    res = Math.min(res,nums[mid]);

                }

                high = mid - 1;
            }
        }

        return minIndex;
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

class Solution {
    public int removeElement(int[] nums, int val) {
        int l=0,r=nums.length-1;

        while(l<r){
            if(nums[l]==val){
                while(l<r && nums[r]==val){
                    r--;
                }
                swap(nums,l,r);
                r--;
            }
                l++;
        }

        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                return cnt;
            }
            cnt++;
        }
        return cnt;

    }
}

private void swap(int[] nums,int l,int r){
    int tmp=nums[l];
    nums[l]=nums[r];
    nums[r]=tmp;
}


/*3,3,3,3,3,3,3,4,4,3,3,3,3*/
class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length-1;
        int slow=0,fast=0;
        slow=0;//1;
        fast=0;//1
        do{
            slow=nums[slow];//2
            fast=nums[fast];//2
            fast=nums[fast];//3
        }while(slow!=fast);
        if(slow==fast){
            slow=0;
        }
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}

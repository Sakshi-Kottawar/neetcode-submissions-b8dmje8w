class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int jumps=0;

        int l=0,r=0,farthest=0;
        int k=0;
        while(farthest<n-1){
            k=l;
            while(k<=r){
                farthest=Math.max(farthest,k+nums[k]);
                k++;
            }
            l=r+1;
            r=farthest;
            jumps++;
        }
        return jumps;
    }
}

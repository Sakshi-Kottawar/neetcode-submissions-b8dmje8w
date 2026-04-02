class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }
        int high=1;
        for(int i=0;i<nums.length;i++){
            if(!hs.contains(nums[i]-1)){
                int num=nums[i];
                int tmp=1;
                while(hs.contains(num+1)){
                    num++;
                    tmp++;
                    if(tmp>high){
                        high=tmp;
                    }
                }
            }
        }
        return high;
    }
}

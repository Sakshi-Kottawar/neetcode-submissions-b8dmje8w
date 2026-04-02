class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
            if(hs.size()!=i+1){
                return true;
            }
        }
        if(hs.size()!=nums.length){
            return true;
        }
        return false;
    }
}
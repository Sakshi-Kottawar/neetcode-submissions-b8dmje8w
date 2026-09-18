class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();

        List<Integer> tmp=new ArrayList<>();

        helper(res,tmp,nums,target,0,0);

        return res;
    }

    private void helper( List<List<Integer>> res, List<Integer> tmp,int[] nums, int target,int startI,int currSum){

        if(currSum>target)return;
        
        if(currSum==target){
            res.add(new ArrayList<>(tmp));
            return;
        }

        for(int i=startI;i<nums.length;i++){
            currSum+=nums[i];
            tmp.add(nums[i]);
            helper(res,tmp,nums,target,i,currSum);
            tmp.remove(tmp.size()-1);
            currSum-=nums[i];
        }
        

    }
}

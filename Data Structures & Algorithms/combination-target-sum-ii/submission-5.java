class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> tmp=new ArrayList<>();

        helper(res,tmp,candidates,target,0);

        return res;
    }

    private void helper( List<List<Integer>> res, List<Integer> tmp,int[] nums, int target,int startI){

        if(target<0)return;
        
        if(target==0){
            res.add(new ArrayList<>(tmp));
            return;
        }


        for(int i=startI;i<nums.length;i++){
            if(i>startI && nums[i]==nums[i-1])continue;
            tmp.add(nums[i]);
            helper(res,tmp,nums,target-nums[i],i+1);
            tmp.remove(tmp.size()-1);
        }
        

    }
}

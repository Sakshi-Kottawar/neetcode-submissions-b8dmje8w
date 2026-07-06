class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res =new ArrayList<>();
        List<Integer> tmp=new ArrayList<>();

        solve(res,tmp,nums,target,0);
        return res;
    }

    private void solve(List<List<Integer>> res,List<Integer> tmp,int[] nums,int target,int start){
        
        if(target==0){
            res.add(new ArrayList<>(tmp));
            return;
        }

        if(target<0)return;


        for(int i=start;i<nums.length;i++){
            tmp.add(nums[i]);
            solve(res,tmp,nums,target-nums[i],i);
            tmp.remove(tmp.size()-1);
        }

    }
}

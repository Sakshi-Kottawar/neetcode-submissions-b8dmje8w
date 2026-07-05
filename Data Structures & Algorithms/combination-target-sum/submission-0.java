class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res =new ArrayList<>();
        List<Integer> tmp=new ArrayList<>();

        solve(res,tmp,nums,target,0);
        return res;
    }

    private void solve(List<List<Integer>> res,List<Integer> tmp,int[] nums,int target,int idx){
        if(idx==nums.length && target==0){
            List<Integer> t1=new ArrayList<>(tmp);
            res.add(t1);
            return;
        }
        if(target<0 || idx==nums.length){
            return;
        }

        tmp.add(nums[idx]);
        solve(res,tmp,nums,target-nums[idx],idx);

        tmp.remove(tmp.size()-1);
        solve(res,tmp,nums,target,idx+1);
    }
}

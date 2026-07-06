class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> tmp=new ArrayList<>();
        solve(res,tmp,nums,0);
        return res;
    }

    private void solve(List<List<Integer>> res,List<Integer> tmp,int[]nums,int start){

        res.add(new ArrayList<>(tmp));

        for(int i=start;i<nums.length;i++){
            tmp.add(nums[i]);
            solve(res,tmp,nums,i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}

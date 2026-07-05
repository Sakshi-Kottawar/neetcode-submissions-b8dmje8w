class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> tmp=new ArrayList<>();

        solve(res,tmp,0,nums);
        return res;
    }

    private void solve(List<List<Integer>> res,List<Integer> tmp,int idx,int[] nums){
        if(idx==nums.length){
            List<Integer> t1=new ArrayList<>(tmp);
            res.add(t1);
            return;
        }


        tmp.add(nums[idx]);
        solve(res,tmp,idx+1,nums);

        tmp.remove(tmp.size()-1);
        solve(res,tmp,idx+1,nums);


        

    }
}

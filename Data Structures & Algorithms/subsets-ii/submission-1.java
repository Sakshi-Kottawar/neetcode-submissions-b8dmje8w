class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> tmp=new ArrayList<>();
        Arrays.sort(nums);
        solve(res,tmp,0,nums);
        return res;
    }

    private void solve(List<List<Integer>> res,List<Integer> tmp,int start,int[] nums){
    
        res.add(new ArrayList<>(tmp));
        
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1])continue;
            tmp.add(nums[i]);
            solve(res,tmp,i+1,nums);
            tmp.remove(tmp.size()-1);
        }
    
    
    }
}

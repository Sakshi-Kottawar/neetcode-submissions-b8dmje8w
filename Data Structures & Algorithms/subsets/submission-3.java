class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> tmp=new ArrayList<>();

        helper(nums,res,tmp,0);
        return res;
    }

    private void helper(int[] nums,List<List<Integer>> res,List<Integer> tmp,int start){
        res.add(new ArrayList<>(tmp));

        for(int i=start;i<nums.length;i++){
            tmp.add(nums[i]);
            helper(nums,res,tmp,i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}

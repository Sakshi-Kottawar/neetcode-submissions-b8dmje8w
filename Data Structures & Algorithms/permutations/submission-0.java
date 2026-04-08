class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        solve(res,0,nums);
        return res;
    }

    private void solve(List<List<Integer>> res,int si,int[]nums){
        if(si==nums.length-1)
            res.add(toList(nums));
        for(int i=si;i<nums.length;i++){
            swap(si,i,nums);
            solve(res,si+1,nums);
            swap(si,i,nums);
        }
    }

    void swap(int i,int j,int[] nums){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

    private List<Integer> toList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            list.add(n);
        }
        return list;
    }
}

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> tmp=new ArrayList<>();

        helper(res,tmp,nums,0);
        return res;
    }

    private void helper( List<List<Integer>> res,List<Integer> tmp,int[] nums,int start){
        if(start==nums.length-1){
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
        }

        for(int i=start;i<nums.length;i++){
            swap(i,start,nums);
           
            helper(res,tmp,nums,start+1);
            swap(i,start,nums);
           
        }
    }

    private void swap(int i,int j,int[] nums){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}

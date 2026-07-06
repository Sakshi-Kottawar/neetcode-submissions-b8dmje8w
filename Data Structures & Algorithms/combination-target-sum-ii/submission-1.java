class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> tmp=new ArrayList<>();

        Arrays.sort(candidates);
        solve(res,tmp,candidates,target,0);
        return res;
    }

    private void solve(List<List<Integer>> res,List<Integer> tmp,int[] cand,int target,int idx){
        if(target==0){
            List<Integer> ll=new ArrayList<>(tmp);
            res.add(ll);
            return;
        }
        if(target<0 || idx==cand.length){
            return;
        }

        
        if (target - cand[idx] >= 0) {
        //pick
        tmp.add(cand[idx]);

        solve(res,tmp,cand,target-cand[idx],idx+1);
        tmp.remove(tmp.size()-1);
        }
        //not pick
        while (idx + 1 < cand.length && cand[idx] == cand[idx + 1]) {
            idx++;
        }
        solve(res,tmp,cand,target,idx+1);
        

    }
}



class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res=new ArrayList<>();
        res.add(new ArrayList<>(List.of(1)));
        if(rowIndex==0)return res.get(0);
        res.add(new ArrayList<>(List.of(1,1)));
        if(rowIndex==1)return res.get(1);

        for(int i=2;i<=rowIndex;i++){
            List<Integer> prev=res.get(i-1);
            List<Integer> tmp=new ArrayList<>();
            tmp.add(1);
            for(int j=1;j<prev.size();j++){
                tmp.add(prev.get(j-1)+prev.get(j));
            }
            tmp.add(1);
            res.add(tmp);
        }
        return res.get(res.size()-1);
    }
}
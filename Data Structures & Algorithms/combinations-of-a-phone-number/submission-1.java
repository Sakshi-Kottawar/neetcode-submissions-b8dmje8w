class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        if(digits.length()==0)return ans;
        StringBuilder tmp=new StringBuilder();
        HashMap<Integer,String> hm=new HashMap<>();
        fillHashmap(hm);
        helper(digits,0,ans,tmp,hm);
        return ans;
    }

    private void helper(String digits,int idx,List<String> ans,StringBuilder tmp,HashMap<Integer,String> hm){
        if(idx==digits.length()){
            String str=tmp.toString();
            ans.add(str);
            return;
        }

        Integer d=Character.getNumericValue(digits.charAt(idx));
        String s=hm.get(d);
        for(int i=0;i<s.length();i++){
            tmp.append(s.charAt(i));
            helper(digits,idx+1,ans,tmp,hm);
            tmp.deleteCharAt(tmp.length()-1);
        }
    }

    private void fillHashmap(HashMap<Integer,String> hm){
        hm.put(2,"abc");
        hm.put(3,"def");
        hm.put(4,"ghi");
        hm.put(5,"jkl");
        hm.put(6,"mno");
        hm.put(7,"pqrs");
        hm.put(8,"tuv");
        hm.put(9,"wxyz");
    }
}

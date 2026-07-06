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

    private void helper(String digits,int start,List<String> ans,StringBuilder tmp,HashMap<Integer,String> hm){
       
        if(start==digits.length()){
            ans.add(tmp.toString());
            return;
        }

        String s=hm.get(Character.getNumericValue(digits.charAt(start)));
        for(int i=0;i<s.length();i++){
            tmp.append(s.charAt(i));
            helper(digits,start+1,ans,tmp,hm);
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

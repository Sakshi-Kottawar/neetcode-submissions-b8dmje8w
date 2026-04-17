class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> tmp=new ArrayList<>();
        helper(s,res,0,tmp);
        return res;

    }

    private void helper(String s,List<List<String>> res,int idx,List<String> tmp){
        if(idx==s.length()){
            res.add(new ArrayList<>(tmp));
            return;
        }
        StringBuilder word=new StringBuilder();
        for(int i=idx;i<s.length();i++){
            word.append(s.charAt(i));
            if(isPalindrome(word.toString())){
                tmp.add(word.toString());
                helper(s,res,i+1,tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    private boolean isPalindrome(String word) {
    int left = 0, right = word.length() - 1;

    while (left < right) {
        if (word.charAt(left) != word.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }

    return true;
}
}

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> tmp=new ArrayList<>();
        helper(s,res,0,tmp);
        return res;

    }

    private void helper(String s,List<List<String>> res,int start,List<String> tmp){
        
       if(start == s.length()){
            res.add(new ArrayList<>(tmp));
            return;
        }


        for(int i=start;i<s.length();i++){
            String str=s.substring(start,i+1);
            if(isPalindrome(str)){
                tmp.add(str);
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

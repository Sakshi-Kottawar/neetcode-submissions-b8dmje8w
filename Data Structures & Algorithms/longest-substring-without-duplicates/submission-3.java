class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int n=s.length();
        HashSet<Character> hs=new HashSet<>();
        int maxL=0;

        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            
            while(hs.contains(ch)){
                hs.remove(s.charAt(left));
                left++;
            }
            hs.add(ch);

            if(right-left+1>maxL){
                maxL=right-left+1;
            }

        }
        return maxL;    
    }
}

//longest
//invalid condition ==>it is in window


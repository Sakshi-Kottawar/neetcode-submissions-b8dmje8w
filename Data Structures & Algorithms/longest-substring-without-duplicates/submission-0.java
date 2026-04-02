class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;int r=0;
        int n=s.length();
        HashSet<Character> hs=new HashSet<>();
        int maxL=0;
        while(r<n){
            char c=s.charAt(r);
            while(hs.contains(c)){
                hs.remove(s.charAt(l));
                l++;      
            }
            
            
            hs.add(c);
            maxL=Math.max(maxL,r-l+1);
            r++;
        }
        return maxL;
        
    }
}

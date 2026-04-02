class Solution {
    public int characterReplacement(String s, int k) {
        int l=0,r=0;
        int maxl=0;
        int n=s.length();
        int maxf=0;
        HashMap<Character,Integer> hm=new HashMap<>();

        while(r<s.length()){
            char c=s.charAt(r);
            hm.put(c,hm.getOrDefault(c,0)+1);
            if(hm.get(c)>maxf)maxf=hm.get(c);

            if(r-l+1-maxf>k){
                    char tmp=s.charAt(l);
                    hm.put(tmp,hm.get(tmp)-1);
                    l++;
                    // maxf=0;
            }
            maxl=Math.max(maxl,r-l+1);
               
            r++;
        }
        return maxl;
    }
}

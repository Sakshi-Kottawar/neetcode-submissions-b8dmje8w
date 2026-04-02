class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
        }

        int l=0,r=0;

        int cnt=hm.size();
        int minl=Integer.MAX_VALUE;
        int si=-1;

        while(r<s.length()){
            char c=s.charAt(r);
            if(hm.containsKey(c)){
                hm.put(c,hm.get(c)-1);
                if(hm.get(c)==0)cnt--;
            }

            while(cnt==0){
                if (r - l + 1 < minl) {
                minl=Math.min(minl,r-l+1);
                si=l;
                }
                char ch=s.charAt(l);
                if(hm.containsKey(ch)){
                    hm.put(ch,hm.get(ch)+1);
                    if(hm.get(ch)>0)cnt++;
                }
                l++;

            }
            
            r++;
        }
        return minl == Integer.MAX_VALUE ? "" : s.substring(si, si + minl);
        }
}

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int cnt=0;
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char c=s1.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
        }

        int l=0,matched=0,r=0;
        int count=hm.size();
        while(r<s2.length()){
            char c=s2.charAt(r);
            if(hm.containsKey(c)){
                hm.put(c,hm.get(c)-1);
                if(hm.get(c)==0){
                    count--;
                }
            }

            // if(r-l+1<s1.length()){
            //     r++;
            //     continue;
            // }
            if(r-l+1==s1.length()){
                if(count==0)return true;
                char ch=s2.charAt(l);
                if(hm.containsKey(ch)){
                    hm.put(ch,hm.get(ch)+1);
                    if(hm.get(ch)==1)count++;
                }
                l++;
            }
            
            r++;
        
        }
        return false;
    }
}

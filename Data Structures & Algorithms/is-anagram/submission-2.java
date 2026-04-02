class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            if(hm.containsKey(c)){
                hm.put(c,hm.get(c)-1);
                if(hm.get(c)==0){
                    hm.remove(c);
                }
            }
            else{
                return false;
            }
            

        }
        if(hm.size()==0)return true;
        return false;

    }
}

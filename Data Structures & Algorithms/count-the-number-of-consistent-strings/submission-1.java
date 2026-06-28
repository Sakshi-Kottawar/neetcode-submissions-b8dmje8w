class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> hs=new HashSet<>();
        for(int i=0;i<allowed.length();i++){
            hs.add(allowed.charAt(i));
        }

        int cnt=0;
        for(int i=0;i<words.length;i++){
            String str=words[i];
            boolean isConsistent=true;
            for(int j=0;j<str.length();j++){
                if(!hs.contains(str.charAt(j))){
                    isConsistent=false;
                    break;
                }
            }
            if(isConsistent)cnt++;
        }
        return cnt;
    }
}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> hm=new HashMap<>();
        for(String s:strs){
            int[] freq=new int[26];
            for(char c:s.toCharArray()){
                freq[c-'a']++;
            }
            StringBuilder sb=new StringBuilder();
            for(int count:freq){
                sb.append(count).append("#");
            }
            String key=sb.toString();

            hm.computeIfAbsent(key,k->new ArrayList<>()).add(s);
            
        }
        return new ArrayList<>(hm.values());
    }
}

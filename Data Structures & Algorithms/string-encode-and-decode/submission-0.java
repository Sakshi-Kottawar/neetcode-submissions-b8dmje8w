class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();
        for(String s:strs){
            if(s==null){
                s="";
            }
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();

    }

    public List<String> decode(String s) {
        List<String> strs=new ArrayList<>();
        int i=0;
        while(i<s.length()){
            int len = 0;
            while (s.charAt(i) != '#') {
                len = len * 10 + (s.charAt(i) - '0');  
                i++;
            }            
            i++;
            String str = s.substring(i, i + len);
            strs.add(str);
            i+=len;
            
        }
        return strs;

    }
}

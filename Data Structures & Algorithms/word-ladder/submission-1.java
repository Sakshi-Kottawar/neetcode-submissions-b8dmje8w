class Solution {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> hs=new HashSet<>();
        for(String s:wordList){
            hs.add(s);
        }
        hs.remove(beginWord);  
        int mlevel = bfs(beginWord,endWord,hs);
        return mlevel;
               
    }

    private int bfs(String beginWord, String endWord,Set<String> hs){
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);
        int level=0;
        while(!q.isEmpty()){
            level++;
            int size=q.size();
            for(int k=0;k<size;k++){
                String s=q.poll();
                if(s.equals(endWord)){
                    return level;
                }
                char[] charArr=s.toCharArray();
                for(int i=0;i<charArr.length;i++){
                    for(char ch='a';ch<='z';ch++){
                        if(ch!=charArr[i]){
                            char c =  charArr[i];
                            charArr[i]=ch;
                            String replacedString=new String(charArr);
                            if(hs.contains(replacedString)){
                                hs.remove(replacedString);
                                q.add(replacedString);
                            }
                            charArr[i]= c;
                        }
                    }
                }
            }
        }

    return 0;
    }
}

class Solution {
    public String foreignDictionary(String[] words) {
      List<List<Integer>> adj=new ArrayList<>();

      for(int i=0;i<26;i++){
        adj.add(new ArrayList<>());
      }


        Set<Integer> hs=new HashSet<>();

        for (String w : words) {
            for (char c : w.toCharArray()) {
                if (!hs.contains(c - 'a')) {
                    hs.add(c - 'a');
                }
            }
        }
    
      for(int i=0;i<words.length-1;i++){
        String w1=words[i];
        String w2=words[i+1];

        if (w1.length() > w2.length() && w1.startsWith(w2)) return "";

        int len=Math.min(w1.length(),w2.length());
        for(int j=0;j<len;j++){
            if(w1.charAt(j)!=w2.charAt(j)){
              
                adj.get(w1.charAt(j)-'a').add(w2.charAt(j)-'a');
                break;
            }
        }
      }
        int []indegree=new int[26];

      for(int i=0;i<adj.size();i++){
        for(int node:adj.get(i)){
            if(hs.contains(node)){
                indegree[node]++;
            }
        }
      }

      Queue<Integer> q=new LinkedList<>();
      for(int i=0;i<indegree.length;i++){
        if(indegree[i]==0 && hs.contains(i)){
            q.add(i);
        }
      }

    StringBuilder str=new StringBuilder();
      while(!q.isEmpty()){
        Integer node=q.poll();
        str.append((char)(node+'a'));
        for(int i:adj.get(node)){
            indegree[i]--;
            if(indegree[i]==0){
                q.add(i);
            }
        }
      }

      return hs.size()==str.toString().length()?str.toString():"";


    }
}

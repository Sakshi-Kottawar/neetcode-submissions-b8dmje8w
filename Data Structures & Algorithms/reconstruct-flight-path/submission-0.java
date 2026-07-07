class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,List<String>> hm=new HashMap<>();


        Collections.sort(tickets,(a,b)->{
            if(a.get(0).equals(b.get(0))){
                return a.get(1).compareTo(b.get(1));
            }
            return a.get(0).compareTo(b.get(0));
            }
        );
        for(int i=0;i<tickets.size();i++){
            String src=tickets.get(i).get(0);
            String dest=tickets.get(i).get(1);

            hm.computeIfAbsent(src,k->new LinkedList<>()).add(dest);
        }

        Stack<String> st=new Stack<>();

        dfs("JFK",st,hm);

        List<String> ans = new ArrayList<>();

        while (!st.isEmpty()) {
            ans.add(st.pop());
        }

        return ans;
    }


    private void dfs(String src,Stack<String>st,Map<String,List<String>> hm){

        List<String> neighbors=hm.get(src);

        while (neighbors != null && !neighbors.isEmpty()) {

            String next = neighbors.remove(0);

            dfs(next, st, hm);
        }

        st.push(src);

    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited=new boolean[n];

        int cnt=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                cnt++;
                bfs(adj,visited,i);
            }
        }
        return cnt;
    }

    private void bfs(List<List<Integer>> adj, boolean[] visited,int node){
        Queue<Integer> q=new LinkedList<>();

        q.add(node);
        visited[node]=true;

        while(!q.isEmpty()){
            Integer no=q.poll();

            for(int i:adj.get(no)){
                if(!visited[i]){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }

    }
}

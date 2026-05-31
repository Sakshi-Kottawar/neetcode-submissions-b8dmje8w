class Solution {
    public boolean validTree(int n, int[][] edges) {
            List<List<Integer>> adjList=new ArrayList<>();
            
            boolean[] visited=new boolean[n];
            for(int i=0;i<n;i++){
                adjList.add(new ArrayList<>());
            }
            for(int i=0;i<edges.length;i++){
                    int x=edges[i][0];
                    int y=edges[i][1];
                    adjList.get(x).add(y);
                    adjList.get(y).add(x);  
            } 

            
            if(dfs(0,-1,adjList,visited)){
                return false;
            }
                
            for (boolean v : visited) {
                if (!v) {
                    return false;
                }
            }   

            return true;
    }

    public boolean dfs(int node,int parent,List<List<Integer>> adjList, boolean[] visited){
        visited[node]=true;

        for(int i:adjList.get(node)){
            if(!visited[i]){
                if(dfs(i,node,adjList,visited)){
                        return true;
                }
            }else if(parent!=i){
                return true;
            }
        }
        return false;

    }
}

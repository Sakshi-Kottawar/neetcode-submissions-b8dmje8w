class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        DSU dsu=new DSU(n);
        PriorityQueue<Edge> pq=new PriorityQueue<>((x,y)->x.dist-y.dist);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x1=points[i][0];
                int y1=points[i][1];
                int x2=points[j][0];
                int y2=points[j][1];
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]); 
                pq.add(new Edge(i,j,dist));
            }
        }
        int totalW=0;
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int x=edge.x1;
            int y=edge.y1;
            int dist=edge.dist;
            if(dsu.unionBySize(x,y)){
                dsu.unionBySize(x,y);
                totalW+=dist;
            }

        }
        return totalW;
    }
}
class Edge{
    int x1;
    int y1;
    int dist;
    Edge(int x1,int y1,int dist){
        this.x1=x1;
        this.y1=y1;
        this.dist=dist;
    }
}
class DSU{
    int[]size;
    int[]parent;
    int[]rank;
    int cnt;

    DSU(int n){
        size=new int[n];
        parent=new int[n];
        rank=new int[n];
        cnt=n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
            rank[i] = 1;
        }
    }

    public void unionByRank(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX == rootY) return;
        cnt--;
        
        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        }
        else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        }
        else {
            parent[rootY] = rootX;
            ++rank[rootX];
        } 
        
    }

    public boolean unionBySize(int u, int v){
        int rootU=find(u);
        int rootV=find(v);
        if(rootU==rootV)
        return false;
        if(size[rootU]<size[rootV]){
            parent[rootU]=rootV;
            size[rootV]+=size[rootU];
        }
        else{
            parent[rootV]=rootU;
            size[rootU]+=size[rootV];
        }
        cnt--;
        return true;
    }

    private int find(int node){
        if(parent[node]==node)return node;
        else
            return parent[node]=find(parent[node]);
    }

}

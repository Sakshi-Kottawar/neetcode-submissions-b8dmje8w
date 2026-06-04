class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        DSU dsu=new DSU(n+1);

        for(int i=0;i<n;i++){
            int x=edges[i][0];
            int y=edges[i][1];
            if(!dsu.unionBySize(x,y)){
                return new int[]{x,y};
            }
        }
        return new int[]{};
    }
}
class DSU{
    int components;
    int[] parent;
    int[]size;

    DSU(int n){
        this.components=n;
        this.parent=new int[n];
        this.size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }

    public int find(int x){
        if(x==this.parent[x])return x;
        return this.parent[x]=find(this.parent[x]);
    }

    public boolean unionBySize(int X,int Y){
        int rootX=find(X);
        int rootY=find(Y);

        if(this.parent[rootX]==this.parent[rootY]){
            return false;
        }else if(size[rootX]<=size[rootY]){
            this.parent[rootX]=rootY;
            this.size[rootY]+=this.size[rootX];
        }else{
            this.parent[rootY]=rootX;
            this.size[rootX]+=size[rootY];
        }
        this.components--;
        return true;
    }
}

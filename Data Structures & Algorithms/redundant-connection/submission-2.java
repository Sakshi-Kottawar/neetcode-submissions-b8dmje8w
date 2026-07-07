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
    int []size;
    int[] parent;
    int n;


    DSU(int n){
        this.n=n;
        size=new int[n];
        parent=new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }

    private boolean unionBySize(int a,int b){
        int pa=find(a);
        int pb=find(b);


        if(pa==pb){
            return false;
        }else if(size[pa]>size[pb]){
            parent[pb]=pa;
            size[pa]+=size[pb];
        }else{
            parent[pa]=pb;
            size[pb]+=size[pa];
        }
        n--;
        return true;
    }


    private int find(int a){
        if(parent[a]==a)return a;
        return parent[a]=find(parent[a]);
    }





}

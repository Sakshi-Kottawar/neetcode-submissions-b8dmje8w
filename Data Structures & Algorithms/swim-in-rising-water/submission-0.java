class Solution {
    public int swimInWater(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.wt-y.wt);
        int[][] dist=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        pq.add(new Pair(0,0,grid[0][0]));
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        dist[0][0]=grid[0][0];
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int x=p.x;
            int y=p.y;
            int wt=p.wt;

            if(wt>dist[x][y])continue;
            if(x==m-1 && y==n-1)return wt;

            for(int i=0;i<4;i++){
                int newx=x+dr[i];
                int newy=y+dc[i];
                if(newx>=0 && newx<m && newy>=0 && newy<n){
                    int newWt = Math.max(wt, grid[newx][newy]);

                    if(dist[newx][newy]>newWt){
                        dist[newx][newy]=newWt;
                        pq.add(new Pair(newx,newy,newWt));
                    }
                }
            }

        }
        return -1;

    }
}

class Pair{
    int x;
    int y;
    int wt;
    Pair(int x,int y,int wt){
        this.x=x;
        this.y=y;
        this.wt=wt;
    }
}

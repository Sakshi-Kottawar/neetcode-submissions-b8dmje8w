class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        boolean[][] visited=new boolean[n][m];
        int maxDist=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    // visited[i][j]=true;
                    int dist=bfs(grid,visited,i,j);
                    maxDist=Math.max(maxDist,dist);
                }
            }
        }
        return maxDist;
    }

    int bfs(int[][] grid,boolean[][] visited,int si,int sj){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(si,sj));
        visited[si][sj]=true;
        int dist=0;
        int[]xdir={-1,1,0,0};
        int[]ydir={0,0,-1,1};

        int n=grid.length;
        int m=grid[0].length;


        while(!q.isEmpty()){
            int s=q.size();
            dist=dist+s;
            for(int i=0;i<s;i++){
                Pair p=q.poll();
                int x=p.x;
                int y=p.y;
                for(int j=0;j<4;j++){
                    int newx=x+xdir[j];
                    int newy=y+ydir[j];
                    if(newx>=0 && newx<n && newy>=0 && newy<m && grid[newx][newy]==1 &&!visited[newx][newy]){
                        visited[newx][newy]=true;
                        q.add(new Pair(newx,newy));
                    }
                }
            }
        }
        return dist;

    }
}

class Pair{
    int x;
    int y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        boolean[][] visited=new boolean[n][m];
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    cnt++;
                    bfs(i,j,grid,visited);
                }
            }
        }
        return cnt;
    }

    private void bfs(int i,int j,char[][] grid,boolean[][] visited){
        visited[i][j]=true;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(i,j));
        int n=grid.length;
        int m=grid[0].length;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!q.isEmpty()){
            Pair p=q.poll();
            int row=p.x;
            int col=p.y;
            visited[row][col]=true;

            for(int k=0;k<4;k++){
                int nrow=row+dr[k];
                int ncol=col+dc[k];

                if(nrow>=0 && nrow <n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && !visited[nrow][ncol]){
                    q.add(new Pair(nrow,ncol));
                    visited[nrow][ncol]=true;

                }
            }
        }
        
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

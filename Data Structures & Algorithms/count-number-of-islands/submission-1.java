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
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        visited[i][j] = true; // Mark visited immediately upon adding to queue

        // Direction arrays for 4-directional movement (Up, Down, Left, Right)
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.x;
            int col = p.y;

            // Check all 4 potential neighbors
            for (int k = 0; k < 4; k++) {
                int nrow = row + dr[k];
                int ncol = col + dc[k];

                // Boundary check + Land check + Visited check
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                    && grid[nrow][ncol] == '1' && !visited[nrow][ncol]) {
                    
                    visited[nrow][ncol] = true; // Mark before adding to keep queue short
                    q.add(new Pair(nrow, ncol));
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

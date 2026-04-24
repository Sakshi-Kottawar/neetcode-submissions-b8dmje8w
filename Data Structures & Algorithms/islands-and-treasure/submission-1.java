class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited=new boolean[n][m];

        Queue<Node> q=new LinkedList<>();
        int INF=2147483647;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0 && !visited[i][j])
                {
                    q.add(new Node(i,j,0));
                }
                // if(grid[i][j]!=0 && grid[i][j]!=-1){
                //     grid[i][j]=1;
                // }
            }
        }

        int[] xdir={-1,1,0,0};
        int[] ydir={0,0,-1,1};

        while(!q.isEmpty()){
            Node p=q.poll();
            int x=p.x;
            int y=p.y;
            int dist=p.dist;
            visited[x][y]=true;
            grid[x][y]=dist;
            for(int i=0;i<4;i++){
                int newx = x+xdir[i];
                int newy = y+ydir[i];
                if(newx>=0 && newx<n && newy>=0 && newy<m && !visited[newx][newy] && grid[newx][newy]==INF){
                    visited[newx][newy]=true;
                    q.add(new Node(newx,newy,dist+1));

                }
            }
        }
    }
}

class Node{
    int x;
    int y;
    int dist;
    Node(int x,int y,int dist){
        this.x=x;
        this.y=y;
        this.dist=dist;
    }
}

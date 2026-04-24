class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited=new boolean[n][m];

        Queue<Node> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2 && !visited[i][j]){
                    q.add(new Node(i,j));
                    visited[i][j]=true;
                }
            }
        }

        int[] xdir={-1,1,0,0};
        int[] ydir={0,0,-1,1};
        int t=0;

        while(!q.isEmpty()){
           
            int s=q.size();

            boolean isRotten=false;
            for(int i=0;i<s;i++){
                Node node=q.poll();
                int x=node.x;
                int y=node.y;
                for(int j=0;j<4;j++){
                    int newx=x+xdir[j];
                    int newy=y+ydir[j];
                    if(newx>=0 && newx<n && newy>=0 && newy<m && !visited[newx][newy] && grid[newx][newy]==1)
                    {
                        visited[newx][newy]=true;
                        q.add(new Node(newx,newy));
                        isRotten=true;
                    }
                }
                
            }
            if(isRotten)t++;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                   return -1;
                }
            }
        }
        return t;
    }
}
class Node{
    int x;
    int y;
    Node(int x,int y){
        this.x=x;
        this.y=y;
    }
}

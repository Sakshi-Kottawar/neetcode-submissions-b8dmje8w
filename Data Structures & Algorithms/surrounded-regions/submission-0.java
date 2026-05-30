class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] visited=new boolean[m][n];
        boolean isSurr=false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //travelling borders
                if(board[i][j]=='O' && !visited[i][j] && (i==0 || j==0 || i== m-1 || j==n-1)){
                    visited[i][j]=true;
                    board[i][j] = '#';  
                    dfs(board,visited,i,j);
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';  
                } else if(board[i][j] == '#') {
                    board[i][j] = 'O';  
                }
            }
        }
    }

    public void dfs(char[][] board,boolean[][] visited,int i,int j){
        int m=board.length;
        int n=board[0].length;
        

        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};


        for(int k=0;k<4;k++){
            int newx=i+dr[k];
            int newy=j+dc[k];
            if(newx>=0 && newx <m && newy >=0 && newy<n){
                if(board[newx][newy]=='O' && !visited[newx][newy]){
                    board[newx][newy]='#';
                    visited[newx][newy]=true;
                    dfs(board,visited,newx,newy);
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

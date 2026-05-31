class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0){
                    pacific[i][j]=true;
                    dfs(i,j,heights,pacific);
                }
                if(i==m-1 || j==n-1){
                    atlantic[i][j]=true;
                    dfs(i,j,heights,atlantic);
                }
            }
        }
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> tmp=new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    res.add(tmp);
                }
            }
        }

        return res;

    }

    private void dfs(int i,int j,int[][] heights,boolean[][] visited){
        int m = heights.length;
        int n = heights[0].length;

        int[]dr={-1,1,0,0};
        int[] dc={0,0,-1,1};

        for(int k=0;k<4;k++){
            int newx=i+dr[k];
            int newy=j+dc[k];

            if(newx>=0 && newx<m && newy>=0 && newy<n){
                if(!visited[newx][newy] && heights[i][j]<=heights[newx][newy]){
                    visited[newx][newy]=true;
                    dfs(newx,newy,heights,visited);
                }
            }
        }
    }
}

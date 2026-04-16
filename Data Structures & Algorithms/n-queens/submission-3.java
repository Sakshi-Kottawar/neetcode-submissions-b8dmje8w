class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        // if(n==2 || n==3)return res;
        // if(n==1){
        //     List<String> tmp=new ArrayList<>();
        //     tmp.add("Q");
        //     res.add(tmp);
        //     return res;
        // }
        int[][] board=new int[n][n];
        List<Integer> tmp=new ArrayList<>();
        helper(0,res,n,board,tmp);
        return res;
    }

    private void helper(int colIdx,List<List<String>> res,int n,int[][] board,List<Integer> tmp)
    {
        if(colIdx==n){
            List<String> word=new ArrayList<>();
            for(int j=0;j<tmp.size();j++){
                StringBuilder str=new StringBuilder();
                for(int i=0;i<n;i++){
                    if(i==tmp.get(j))
                        str.append("Q");
                    else
                        str.append(".");
                }
                word.add(str.toString());
            }
            res.add(word);
            return;
        }
        for(int r=0;r<n;r++){
            if(check(colIdx,r,n,board)){
                tmp.add(r);
                board[r][colIdx]=1;
                helper(colIdx+1,res,n,board,tmp);
                board[r][colIdx]=0;
                tmp.remove(tmp.size()-1);
            }
        }

    }

    private boolean check(int c,int r,int n,int[][] board)
    {
        //check row
        for(int i=0;i<c;i++){
            if(board[r][i]==1)
                return false;
        }

        //check diag1
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }
        
        // Check lower-left diagonal
        for (int i = r + 1, j = c - 1; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) return false;
        }
        return true;
    }
}

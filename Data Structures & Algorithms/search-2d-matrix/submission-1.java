class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int col=matrix[0].length;
        int row=matrix.length;
        int low=0,high=row-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(target==matrix[mid][0]){
                return true;
            }else if(target<matrix[mid][0]){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        int rowi=high;
        if(rowi<0)return false;
        low=0;high=col-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(target==matrix[rowi][mid]){
                return true;
            }else if(target<matrix[rowi][mid]){
                high=mid-1;;
            }else{
                low=mid+1;
            }
        }
        return false;
    }
}

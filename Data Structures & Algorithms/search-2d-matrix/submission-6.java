class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex=binarySearch(matrix,target);
        if(rowIndex==-1)return false;
        int low=0;
        int high=matrix[0].length-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            
            if(matrix[rowIndex][mid]==target){
                return true;
            }else if (matrix[rowIndex][mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return false;
    }

    private int binarySearch(int[][] matrix, int target){
        int low=0;
        int high=matrix.length-1;
        int rowIndex=-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(matrix[mid][0]==target){
                return mid;
            }else if(matrix[mid][0]>target){
                high=mid-1;
            }else{
                rowIndex=mid;
                low=mid+1;
            }
        }
        return rowIndex;
    }
}
//each row in increasing order
//
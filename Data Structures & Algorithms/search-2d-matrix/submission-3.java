class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //for first column find the lower bound

        int rowIndex=binarySearch(matrix,target,0,matrix.length);

        if(rowIndex!=-1)
            return binarySearchRow(matrix[rowIndex],0,matrix[0].length,target);
        return false;
    }


    private int binarySearch(int[][] matrix, int target,int l,int r){
        int result=-1;
        while(l<r){
            int mid=l+(r-l)/2;

            if(matrix[mid][0]<=target){
                result=mid;
                l++;
            }else{
                r--;
            }

        }
        return result;

    }

    private boolean binarySearchRow(int[] nums,int l,int r,int target){
        while(l<r){
            int mid=l+(r-l)/2;

            if(nums[mid]==target){
                return true;
            }else if(nums[mid]<target){
                l++;
            }else{
                r--;
            }

        }
        return false;

    }
}

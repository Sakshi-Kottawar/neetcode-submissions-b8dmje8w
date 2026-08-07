class Solution {

    public int[] sortArray(int[] nums) {
        
        int n=nums.length-1;
        sort(nums,0,n);
        return nums;
    }

    private void sort(int[] nums,int left,int right){
        if(left<right){

            int mid=left+(right-left)/2;

            sort(nums,left,mid);
            sort(nums,mid+1,right);

            merge(nums,left,mid,right);

        }


    }

    private void merge(int[] nums,int left,int mid,int right){

        int n1=mid-left+1;
        int n2=right-mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(nums, left, leftArray, 0, n1);
        System.arraycopy(nums, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                nums[k] = leftArray[i];
                i++;
            } else {
                nums[k] = rightArray[j];
                j++;
            }
            k++;
        }
        // Copy remaining elements of leftArray[] if any
        while (i < n1) {
            nums[k] = leftArray[i];
            i++;
            k++;
        }
        // Copy remaining elements of rightArray[] if any
        while (j < n2) {
            nums[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
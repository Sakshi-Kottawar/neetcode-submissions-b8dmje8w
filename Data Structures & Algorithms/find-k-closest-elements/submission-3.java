class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int n=arr.length;

        int index=binarySearch(arr,x);
        // System.out.println("index is "+index);
        int leftI=index;
        int rightI=index+1;
        ArrayList<Integer> res = new ArrayList<>();

        if(index==-1){
            ArrayList<Integer> res1 = new ArrayList<>();
            for(int i=0;i<k;i++){
                res1.add(arr[i]);
            }
            return res1;
        }else if (index==n-1){
            ArrayList<Integer> res1 = new ArrayList<>();
            for(int i=n-k;i<n;i++){
                res1.add(arr[i]);
            }
            return res1;
        }

        while(leftI>=0 && rightI<n && res.size()<k){
            if(Math.abs(arr[leftI]-x)>Math.abs(arr[rightI]-x)){
                res.add(arr[rightI]);
                rightI++;
            }else{
                res.add(0,arr[leftI]);
                leftI--;
            }
            // System.out.println("res"+res);

        }

        while (res.size() < k && rightI < n) {
            res.add(arr[rightI]);
            rightI++;
        }

        // If right side is exhausted
        while (res.size() < k && leftI >= 0) {
            res.add(0, arr[leftI]);
            leftI--;
        }
        return res;
    }

    private int binarySearch(int [] arr,int x){
        int left=0;
        int right=arr.length-1;
        int resIndex=-1;
        while(left<=right){
            int mid=left+(right-left)/2;

           if(arr[mid]<=x){
                resIndex=mid;
                left = mid + 1;
            }else{
                 right=mid-1;
            }
        }
        return resIndex;
    }
}

//find k elements that are near x
//result is sorted

//find the element thst is just smaller or equal to x using binary Search
//left pointer to that elem,rigth to left+1,if right>=n set it to max value


//two edge cases
//if the value is less that first value
//then set right to first element and left to max value
//is the value is greater than last element
//then set left to last element,right>=n set it to max value
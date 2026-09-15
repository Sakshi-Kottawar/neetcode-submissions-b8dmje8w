class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int i=0;i<n;i++){
            high+=weights[i];
            low=Math.max(low,weights[i]);
        }
        int res=high;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(check(mid,weights,days)){
                // System.out.println("mid is true for "+mid);
                res=Math.min(res,mid);
                high=mid-1;
            }else{
                low=mid+1;
            }
            // System.out.println("res is true for "+res);

        }

        return res;
    }

    private boolean check(int mid,int[] weights, int days){
        int noOfDaysRequired=1;
        int currW=0;
        for(int i=0;i<weights.length;i++){
            currW+=weights[i];
            if(currW>mid){
                noOfDaysRequired++;
                currW=weights[i];
            }
        }
        // System.out.println("mid is"+mid);
        // System.out.println("noOfDaysRequired is"+noOfDaysRequired);

        return noOfDaysRequired<=days?true:false;
    }
}
//maxCapcity?
//minimumCapcity required=max(weights[i])
//max=sum of all
//6,7,3,10

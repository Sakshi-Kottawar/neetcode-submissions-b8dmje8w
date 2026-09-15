class Solution {
    public int mySqrt(int x) {
        int low=0;
        int high=x/2;
        int res=0;

        if(x==0 || x==1)return x;
        if(x==2)return 1;

        while(low<=high){
            int mid=low+(high-low)/2;
            long tmp=(long)mid*mid;

            if(tmp==x){
                return mid;
            }else if(tmp>x){
                high=mid-1;
            }else{
                res=mid;
                low=mid+1;
            }
        }
        return res;

    }
}
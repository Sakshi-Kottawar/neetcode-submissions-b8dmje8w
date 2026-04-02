class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=Integer.MIN_VALUE;

        for(int i:piles){
            high=Math.max(high,i);
        }
        int k=1;
        while(low<=high){
            int mid=low+(high-low)/2;
            boolean isPos=compute(mid,piles,h);
            if(isPos){
                high=mid-1;
                k=mid;
            }else{
                low=mid+1;
            }
        }
        return k;
    }
    private boolean compute(int mid,int[] piles,int h){
        int noOfhours=0;
        for(int i=0;i<piles.length;i++){
            // noOfhours+=Math.ceil(piles[i]/mid);
            noOfhours += (piles[i] + mid - 1) / mid; 
        }
        if(noOfhours<=h)return true;
        return false;

    }
}

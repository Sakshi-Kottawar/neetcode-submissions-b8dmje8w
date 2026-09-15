class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int n=piles.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            max=Math.max(max,piles[i]);
        }
        int low=1;
        int high=max;

        int res=max;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(check(mid,piles,h)){
                res=Math.min(res,mid);
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return res;
        
    }

    private boolean check(int mid,int[] piles,int h){
        int hoursR=0;
        // System.out.println("mid"+mid);

        for(int i=0;i<piles.length;i++){
            if((piles[i]%mid)==0){
                hoursR+=(piles[i]/mid);
            }else{
                hoursR+=((piles[i]/mid)+1);
            }
            // System.out.println("hoursR"+hoursR);

        }
        // System.out.println("FinalhoursR"+hoursR);
        return hoursR<=h?true:false;
    }
}
//in each hour we can eat atkmost 1 pile
//if h<piles.length==>not possible
//minEating speed 1 banana per hour
//maxEating Speed max(piles)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int cnt=0;
        int n=intervals.length;

        
        Arrays.sort(intervals,((a,b)->{
            if(a[0]!=b[0]){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(a[1],b[1]);
        }));
        int lastTime=intervals[0][1];
        
        for(int i=1;i<n;i++){

            if(intervals[i][0]<lastTime){
                lastTime=Math.min(lastTime,intervals[i][1]);
                cnt++;
            }else{
                lastTime=intervals[i][1];
            }

        }

        return cnt;
    }
}

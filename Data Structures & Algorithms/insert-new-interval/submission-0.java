class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        List<int[]> res = new ArrayList<>();    
        int j=0;
        while(j<n && newInterval[0]>intervals[j][1]){
            res.add(intervals[j]);
            j++;
        }
        while(j<n && intervals[j][0] <= newInterval[1]){
            newInterval[0]=Math.min(newInterval[0],intervals[j][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[j][1]);
            j++;
        }
        res.add(newInterval);
       
        while(j<n){
            res.add(intervals[j]);;
            j++;
        }
        return res.toArray(new int[res.size()][]);
    }
}

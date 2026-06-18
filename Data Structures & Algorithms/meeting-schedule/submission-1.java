/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        int n=intervals.size();
        if(n==0 || n==1)return true;
        Collections.sort(intervals,((a,b)->{
            if(a.start==b.start){
                return Integer.compare(a.end,b.end);

            }
            return Integer.compare(a.start,b.start);
        }));
        for(int i=1;i<n;i++){
            Interval prev=intervals.get(i-1);
            Interval curr=intervals.get(i);
            if(prev.end>curr.start){
                return false;
            }
        }
        return true;
    }
}

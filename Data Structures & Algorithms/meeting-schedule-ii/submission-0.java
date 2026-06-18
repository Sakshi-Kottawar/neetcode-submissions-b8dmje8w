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
    public int minMeetingRooms(List<Interval> intervals) {
        int cnt=0;
        int n=intervals.size();
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        for(int i=0;i<n;i++){
            Interval interval=intervals.get(i);
            start.add(interval.start);
            end.add(interval.end);
        }
        Collections.sort(start);
        Collections.sort(end);

        int i=0,j=0;
        int result=0;
        while(i<n && j<n){
            if(start.get(i)<end.get(j)){
                cnt++;
                result=Integer.max(result,cnt);
                i++;
            }else{
                cnt--;
                j++;
            }
        }
        return result;
    }
}

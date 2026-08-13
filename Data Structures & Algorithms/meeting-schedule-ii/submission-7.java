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
        if(intervals.size()==1 || intervals.size()==0)return intervals.size();
        Collections.sort(intervals,(a,b)->{
            return a.start- b.start;
        });
        int minMeetRooms=1;
        PriorityQueue<Integer> endTimes=new PriorityQueue<>();
        endTimes.add(intervals.get(0).end);
        for(int i=1;i<intervals.size();i++){
            Interval prev=intervals.get(i-1);
            Interval curr=intervals.get(i);
            if(prev.end>=curr.start){
                if(!endTimes.isEmpty() && endTimes.peek()<=curr.start){
                    endTimes.poll();
                }else{
                    minMeetRooms++;
                }
                endTimes.add(curr.end);
                
            }
        }
        return minMeetRooms;
    }
}

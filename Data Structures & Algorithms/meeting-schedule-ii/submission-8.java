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
        int n=intervals.size();
        int[] start=new int[n];
        int[] end=new int[n];
        int i=0;

        for(Interval interval:intervals){
            start[i]=interval.start;
            end[i]=interval.end;
            i++;
        }

        Arrays.sort(start);
        Arrays.sort(end);
        int j=0,k=0;
        int gates=0;
        int maxGates=0;
        while(j<n && k<n){
            if(start[j]<end[k]){
                gates++;
                maxGates=Math.max(maxGates,gates);
                j++;
            }else{
                k++;
                gates--;
            }
        }
        return maxGates;

    }
}

/**
 * Definition for an Interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        // Base case: if there are no meetings, no rooms are needed
        if (intervals == null || intervals.isEmpty()) {
            return 0;
        }

        // 1. Sort the intervals by their start times
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        // 2. Min-heap to keep track of the end times of rooms in use
        PriorityQueue<Integer> roomsHeap = new PriorityQueue<>();

        // 3. Process each meeting
        for (Interval interval : intervals) {
            // If the room that frees up earliest is ready, reuse it
            if (!roomsHeap.isEmpty() && interval.start >= roomsHeap.peek()) {
                roomsHeap.poll();
            }

            // Allocate the current room (or a reused one) by adding its end time
            roomsHeap.add(interval.end);
        }

        // 4. The size of the heap is the total number of rooms required
        return roomsHeap.size();
    }
}

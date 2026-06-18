class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return new int[0][2];
        }
        List<int[]> res = new ArrayList<>();
         Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); 
            } else {
                return Integer.compare(a[1], b[1]); 
            }
        });
        int n=intervals.length;
        res.add(intervals[0]);
        int i=1;
        while(i<n){
            int[] lastInterval = res.get(res.size() - 1);
            if(intervals[i][0]<=lastInterval[1]){
                lastInterval[1] = Math.max(lastInterval[1], intervals[i][1]);
            }else{
                res.add(intervals[i]);;
            }
            i++;
        }
        return res.toArray(new int[res.size()][]);

    }
}

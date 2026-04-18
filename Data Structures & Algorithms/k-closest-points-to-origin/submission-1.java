class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> maxHeap=new PriorityQueue<>((a, b) -> Integer.compare(b.dist, a.dist));
        for(int i=0;i<points.length;i++){
            int x=points[i][0];
            int y=points[i][1];
            int dist=x*x+y*y;
            maxHeap.add(new Pair(dist,new int[]{x,y}));
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        int[][] res=new int[k][2];
        int i=0;
        while(maxHeap.size()>0){
            Pair p=maxHeap.poll();
            res[i]=p.coords;
            i++;
        }
        return res;
        

    }
}
class Pair{
    int dist;
    int[] coords;

    Pair(int dist,int[] coords){
        this.dist=dist;
        this.coords=coords;
    }

}
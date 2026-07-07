class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adjList=new ArrayList<>();

        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v=times[i][1];
            int wt=times[i][2];
            adjList.get(u).add(new int[]{v,wt});
        }


        //node,wt
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);

        int dist[]=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        pq.add(new int[]{k,0});
        dist[k]=0;

        while(!pq.isEmpty()){
            int[] pair=pq.poll();
            int node=pair[0];
            int d=pair[1];


            if(d>dist[node])continue;

            for(int[] neigh:adjList.get(node)){
                int neighNode=neigh[0];
                int wt=neigh[1];

                if(dist[neighNode]>dist[node]+wt){
                    dist[neighNode]=dist[node]+wt;
                    pq.add(new int[]{neighNode,dist[neighNode]});
                }

            }

        }
        int max=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max=Math.max(dist[i],max);
        }
        return max;

    }
}

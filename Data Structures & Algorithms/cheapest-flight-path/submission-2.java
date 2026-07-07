class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            int u=flights[i][0];
            int v=flights[i][1];
            int wt=flights[i][2];
            adj.get(u).add(new int[]{v,wt});
        }

        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        //node,dist,stops
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{src,0,0});


        while(!pq.isEmpty()){
            int[] tuple=pq.poll();
            int node=tuple[0];
            int d=tuple[1];
            int stops=tuple[2];

            if(stops>k)continue;


            for(int[] neigh:adj.get(node)){
                int neighNode=neigh[0];
                int neighWt=neigh[1];

                if(dist[neighNode]>d+neighWt && stops<=k){
                    dist[neighNode]=d+neighWt ;
                    pq.add(new int[]{neighNode,dist[neighNode],stops+1});
                }
            }
             

        }
            if(dist[dst]==Integer.MAX_VALUE)return -1;
                return dist[dst];



    }
}

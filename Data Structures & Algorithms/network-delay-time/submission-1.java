class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->
            a.wt-b.wt);
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            int x=times[i][0];
            int y=times[i][1];
            int z=times[i][2];
            adj.get(x).add(new Pair(y,z));
        }
        pq.add(new Pair(k,0));
        int dist[]=new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k]=0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int node=p.node;
            int wt=p.wt;

            if (wt > dist[node]) continue;


            for(Pair pn:adj.get(node)){
                if(pn.wt+dist[node]<dist[pn.node]){
                    dist[pn.node]=pn.wt+dist[node];
                    pq.add(new Pair(pn.node,dist[pn.node]));
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=1;i<n+1;i++){
            if(dist[i]==Integer.MAX_VALUE)return -1;
            max=Math.max(dist[i],max);
        }
        return max;
    }
}

class Pair{
    int node;
    int wt;
    Pair(int node,int wt){
        this.node=node;
        this.wt=wt;
    }
}

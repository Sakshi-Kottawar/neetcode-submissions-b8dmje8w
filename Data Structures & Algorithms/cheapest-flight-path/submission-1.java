class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            int x=flights[i][0];
            int y=flights[i][1];
            int z=flights[i][2];
            adj.get(x).add(new Pair(y,z));
        }
        int[]dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        Queue<Tuple> q=new LinkedList<>();
        q.add(new Tuple(0,src,0));
        dist[src]=0;
        while(!q.isEmpty()){
            Tuple t=q.poll();
            int stops=t.stops;
            int node=t.node;
            int price=t.price;
            if(stops>k)continue;
            for(Pair p:adj.get(node)){
                int adjn=p.node;
                int adjp=p.price;
                if((dist[adjn]>price+adjp) && stops<=k){
                    dist[adjn]=price+adjp;
                    q.add(new Tuple(stops+1,adjn,dist[adjn]));

                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE)return -1;
        return dist[dst];
    }
}
class Tuple{
    int stops;
    int node;
    int price;
    Tuple(int stops,int node,int price){
        this.stops=stops;
        this.node=node;
        this.price=price;
    }

}
class Pair
{
    int node;
    int price;
    Pair(int x,int y){
        this.node=x;
        this.price=y;
    }
}

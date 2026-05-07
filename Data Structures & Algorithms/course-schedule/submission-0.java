class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        int n=numCourses;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][1];
            int v=prerequisites[i][0];

            adj.get(u).add(v);
        }
        int[] indegree=new int[n];


        for(int i=0;i<n;i++){
            for(int j:adj.get(i)){
                indegree[j]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int cnt=0;
        while(!q.isEmpty()){
            int node=q.poll();
            cnt++;
            for(int i:adj.get(node)){
                indegree[i]--;
                
                if(indegree[i]==0)q.add(i);
            }

        }

        return cnt==n?true:false;

    }
}

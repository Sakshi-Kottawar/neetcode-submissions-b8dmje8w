class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Pair> maxHeap=new PriorityQueue<>((a,b)->Integer.compare(b.freq,a.freq));
        Queue<Pair> q=new LinkedList<>();
        HashMap<Character,Integer> hm=new HashMap<>();
        
        //insert into hashmap
        for(int i=0;i<tasks.length;i++){
            hm.put(tasks[i],hm.getOrDefault(tasks[i],0)+1);
        }

        //insert into maxHeap
        for(Map.Entry<Character,Integer> entry:hm.entrySet()){
            int freq =entry.getValue();
            char task= entry.getKey();
            maxHeap.add(new Pair(freq,task,0));
        }

        int time=0;
        while(maxHeap.size()>0 || q.size()>0){
            time++;
            if(maxHeap.size()>0){
                Pair p=maxHeap.poll();
                if(p.freq-1>0){
                    q.add(new Pair(p.freq-1,p.tasks,time+n));
                }
            }
            if(q.size()>0 && q.peek().timestamp<=time){
                Pair p=q.poll();
                if(time<p.timestamp)time=p.timestamp;
                maxHeap.add(p);
            }
            
        }
        return time;

    }
}
class Pair{
    int freq;
    char tasks;
    int timestamp;

    Pair(int freq,char tasks,int timestamp){
        this.freq=freq;
        this.tasks=tasks;
        this.timestamp=timestamp;
    }
}

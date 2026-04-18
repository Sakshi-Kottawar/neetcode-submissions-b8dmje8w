class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            maxHeap.add(stones[i]);
        }
        while(maxHeap.size()>1){
            int i=maxHeap.poll();
            int j=maxHeap.poll();
            int ans=i-j;
            maxHeap.add(ans);
        }
        return maxHeap.peek();
    }
}

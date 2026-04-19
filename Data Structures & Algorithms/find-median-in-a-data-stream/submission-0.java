class MedianFinder {
    PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap=new PriorityQueue<>();

    public MedianFinder() {
        maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        minHeap=new PriorityQueue<>();

    }
    
    public void addNum(int num) {
        if(maxHeap.size()==0 || maxHeap.peek()>num){
            maxHeap.add(num);
        }else
            minHeap.add(num);
        
        if(maxHeap.size()>minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }
        if(maxHeap.size()<minHeap.size())
            maxHeap.add(minHeap.poll());

    }
    
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return maxHeap.peek()/2.0+minHeap.peek()/2.0;
        }else
            return maxHeap.peek();
    }
}

class MedianFinder {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);                // 先进较小的一半
        minHeap.offer(maxHeap.poll());     // 把较小一半的最大值交给较大的一半,保证有序
        if (minHeap.size() > maxHeap.size() + 1) {  // 平衡大小
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (minHeap.size() > maxHeap.size())    return (double) minHeap.peek();
        else return (double) (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
}

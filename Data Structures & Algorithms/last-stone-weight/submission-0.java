class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone: stones){
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int h1 = maxHeap.poll();
            int h2 = maxHeap.poll();
            if (h1 == h2)   continue;
            else    maxHeap.offer(h1 - h2);
        }

        if (maxHeap.size() == 1)    return maxHeap.peek();
        else    return 0;
    }
}

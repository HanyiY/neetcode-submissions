class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // nums -> minHeap: while #elements > k, poll
        // poll rest into result array
        // O(nlogk); O(k)
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n: nums){
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = 
            new PriorityQueue<>((a, b) -> Integer.compare(countMap.get(a), countMap.get(b)));
        for (int key: countMap.keySet()){
            minHeap.offer(key);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++){
            res[i] = minHeap.poll();
        }

        return res;
    }
}

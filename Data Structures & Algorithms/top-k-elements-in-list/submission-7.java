class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> countMap = new HashMap<>();
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(countMap.get(b), countMap.get(a)));
        for (int i : nums){
            countMap.put(i, 1 + countMap.getOrDefault(i, 0));
        }
        for (int i : countMap.keySet()){
            maxHeap.offer(i);
        }
        for (int i = 0; i < k; i++){
            res[i] = maxHeap.poll();
        }
        return res;
    }
}

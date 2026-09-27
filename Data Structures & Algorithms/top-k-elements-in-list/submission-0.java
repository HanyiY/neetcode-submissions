class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        for (Map.Entry<Integer, Integer> entry: freqMap.entrySet()){
            maxHeap.offer(entry);
        }

        for (int i = 0; i < k; i++){
            res[i] = maxHeap.poll().getKey();
        }

        return res;
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            maxHeap.offer(nums[i]);
        }
        res[0] = maxHeap.peek();
        for (int i = 1; i < res.length; i++) {
            maxHeap.remove(nums[i - 1]);
            maxHeap.offer(nums[i + k - 1]);
            res[i] = maxHeap.peek();
        }
        return res;
    }
}

// monoStack: 2 1
// first -> last
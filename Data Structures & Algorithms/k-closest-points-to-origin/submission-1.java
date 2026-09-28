class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        Map<Integer, Integer> pointsMap = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(pointsMap.get(a), pointsMap.get(b)));

        for (int i = 0; i < points.length; i++){
            pointsMap.put(i, points[i][0] * points[i][0] + points[i][1] * points[i][1]);
            minHeap.offer(i);
        } 
        
        for (int i = 0; i < k; i++){
            res[i] = points[minHeap.poll()];
        }

        return res;
        
    }
}

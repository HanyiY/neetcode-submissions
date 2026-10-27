class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // [<[2,1], [4,4]>, <[3, 1]>, <4, 1 .0>, <>]
        List<int[]>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++)    graph[i] = new ArrayList<>();
        for (int[] edge: times) graph[edge[0]].add(new int[]{edge[1], edge[2]});

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        minHeap.offer(new int[]{k, 0});

        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int curDist = cur[1], curNode = cur[0];
            // 跳过过期的
            if (curDist > dist[curNode])    continue;

            for (int[] edge: graph[curNode]) {
                if (dist[curNode] + edge[1] < dist[edge[0]]) {
                    dist[edge[0]] = dist[curNode] + edge[1];
                    minHeap.offer(new int[]{edge[0], dist[edge[0]]});
                }
            }
        }

        int time = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE)   return -1;
            else time = Math.max(time, dist[i]);
        }
        return time;
    }
}

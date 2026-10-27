class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 建图:邻接表 graph[u] = list of {v, w}
        List<int[]>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int[] t : times) graph[t[0]].add(new int[]{t[1], t[2]});
        // 2. dist 初始化为"无穷大"
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        //data structure + init
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        minHeap.offer(new int[]{0, k});
        
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int d = cur[0], u = cur[1];
            // discard expired record
            if (d > dist[u])    continue;
            // 核心 relaxation
            for (int[] edge: graph[u]) {
                if (dist[u] + edge[1] < dist[edge[0]]) {
                    dist[edge[0]] = dist[u] + edge[1];
                    minHeap.offer(new int[]{dist[edge[0]], edge[0]});
                }
            }
        }
        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            max = Math.max(max, dist[i]);
            if (dist[i] == Integer.MAX_VALUE)   return -1;
        }
        return max;
    }
}

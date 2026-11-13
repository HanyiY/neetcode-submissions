class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = Integer.MAX_VALUE;
        int[] minCost = new int[n];
        Arrays.fill(minCost, INF);
        minCost[src] = 0;

        for (int round = 0; round <= k; round++) {   // k+1 轮 最多用k+1条边
            //必须要拷贝
            int[] prevCost = Arrays.copyOf(minCost, n);
            for (int[] flight : flights) {
                int a = flight[0], b = flight[1], cost = flight[2];
                if (prevCost[a] == INF) continue; //防止越界；你原本也都到不了
                minCost[b] = Math.min(minCost[b], prevCost[a] + cost); // 用prevCost
            }
        }
        
        return minCost[dst] == INF ? -1 : minCost[dst];
    }
}
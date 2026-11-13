class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = Integer.MAX_VALUE;
        int[] minCost = new int[n];
        Arrays.fill(minCost, INF);
        minCost[src] = 0;

        for (int round = 0; round <= k; round++) {   // k+1 轮
            int[] prevCost = Arrays.copyOf(minCost, n);
            for (int[] flight : flights) {
                int from = flight[0], to = flight[1], price = flight[2];
                if (prevCost[from] == INF) continue;
                minCost[to] = Math.min(minCost[to], prevCost[from] + price);
            }
        }
        
        return minCost[dst] == INF ? -1 : minCost[dst];
    }
}
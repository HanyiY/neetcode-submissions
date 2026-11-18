class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = Integer.MAX_VALUE;
        int[] minCost = new int[n];
        Arrays.fill(minCost, INF);
        minCost[src] = 0;

        for (int round = 1; round <= k + 1; round++) {
            int[] prev = Arrays.copyOf(minCost, n);
            for (int[] flight: flights) {
                int a = flight[0], b = flight[1], c = flight[2];
                if (prev[a] == INF) continue;
                minCost[b] = Math.min(prev[a] + c, minCost[b]);
            }
        }

        return minCost[dst] == INF ? -1 : minCost[dst];
    }
}

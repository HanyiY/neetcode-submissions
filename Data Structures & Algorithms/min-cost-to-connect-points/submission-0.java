class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;
        int totalCost = 0;

        for (int round = 0; round < n; round++) {
            int nextCandidate = -1;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && (nextCandidate == -1 || minDist[i] < minDist[nextCandidate])) {
                    nextCandidate = i;
                }
            }

            //decided the next node
            visited[nextCandidate] = true;
            totalCost += minDist[nextCandidate];

            // update minDist of unvisited nodes
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int dist = Math.abs(points[nextCandidate][0] - points[i][0])
                             + Math.abs(points[nextCandidate][1] - points[i][1]);
                    minDist[i] = Math.min(dist, minDist[i]);
                }
            }

        }

        return totalCost;
    }
}

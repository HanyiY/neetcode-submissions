class Solution {
    private int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }
        for (int[] edge: edges){
            int root1 = find(edge[0]);
            int root2 = find(edge[1]);
            if (root1 == root2) return edge;
            parent[root1] = root2;
        }
        return new int[]{};
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}


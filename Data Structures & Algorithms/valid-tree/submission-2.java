class Solution {
    private int[] parent;
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)  return false;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] edge: edges){
            int root1 = find(edge[0]);
            int root2 = find(edge[1]);
            if (root1 == root2) return false;
            parent[root1] = root2;
        }
        return true;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}

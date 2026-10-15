class Solution {
    private int[] parents;
    public int countComponents(int n, int[][] edges) {
        // Set<Integer> boss = new HashSet<>();
        parents = new int[n];
        int components = n;
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int[] edge : edges) {
            int root1 = find(edge[0]);
            int root2 = find(edge[1]);
            if (root1 != root2){
                parents[root1] = root2;
                components--;
            }
        }
    
        return components;
    }

    private int find(int x) {
        if (parents[x] != x) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }
}

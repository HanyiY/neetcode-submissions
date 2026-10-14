class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[] inDegree = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            // p[1] -> p[0]
            adjList.get(p[1]).add(p[0]);
            inDegree[p[0]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        int taken = 0;

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            res.add(cur);
            taken++;
            for (int nei: adjList.get(cur)) {
                if (--inDegree[nei] == 0)   q.offer(nei);
            }
        }

        if (taken == n) {
            int[] ans = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                ans[i] = res.get(i);
            }
            return ans;
        }else{
            return new int[]{};
        }
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        int n = numCourses;
        int count = 0;
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            int pre = p[1];
            int course = p[0];
            indegree[course]++;
            adj.get(pre).add(course);
        }

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;
            for(int nei: adj.get(cur)) {
                if (--indegree[nei] == 0)   q.offer(nei);
            }
           
        }

        return count == n;
    }
}

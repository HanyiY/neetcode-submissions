class Solution {
    // BFS + In-degree
    // O(V + E) O(V + E)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // initialize adjacency list and indegree array
        List<List<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        // Initialize adj list for each course
        for (int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        // fill in
        // [0, 1] : 1 -> 0
        for (int[] prereq: prerequisites) {
            int course = prereq[0];
            int prereqCourse = prereq[1];
            adjList.get(prereqCourse).add(course);
            inDegree[course]++;
        }

        // initialize queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;

        while (!queue.isEmpty()){
            int cur = queue.poll();
            count++;

            for (int nei: adjList.get(cur)){
                inDegree[nei]--;

                if (inDegree[nei] == 0){
                    queue.offer(nei);
                }
            }
        }

        return count == numCourses;
    




    }
}

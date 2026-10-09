class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] cur = intervals[0];
        res.add(cur);
        
        for (int[] interval: intervals) {
            int start = interval[0];
            int end = interval[1];
            if (cur[1] >= start) {
                cur[1] = Math.max(cur[1], end);
            }else {
                res.add(interval);
                cur = interval;
            }
        }

        return res.toArray(new int[res.size()][2]);
    }
}

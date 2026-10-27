class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] cur = intervals[0];
        res.add(cur);
        // cur是在res里最后加的一个区间
        for (int[] interval: intervals) {
            if (cur[1] >= interval[0]) {
                cur[1] = Math.max(cur[1], interval[1]);
            }else {
                res.add(interval);
                cur = interval;
            }
        }
        
        return res.toArray(new int[res.size()][2]);
    }
}

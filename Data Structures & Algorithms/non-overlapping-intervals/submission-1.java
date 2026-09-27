class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // [1, 2] [1, 4] [2, 4]
        int [] prev = intervals[0]; 
        int res = 0;
        for (int[] interval: intervals){
            if (prev[1] > interval[0]){
                prev[1] = Math.min(prev[1], interval[1]);
                res++;
            }else{
                prev = interval;
            }
        }
        return res - 1;
    }
}

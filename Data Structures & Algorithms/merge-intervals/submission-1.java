class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] cur = intervals[0];
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals){
            if (cur[1] >= interval[0]){
                cur[1] = Math.max(cur[1], interval[1]);
            }else{
                res.add(cur);
                cur = interval;
            }
        }
        res.add(cur);
        return res.toArray(new int[res.size()][]);
    }
}

/*
[1, 4]     cur 

[2, 3]      

[3, 5]
*/


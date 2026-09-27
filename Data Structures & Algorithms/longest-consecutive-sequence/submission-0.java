class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);
        for (int start: set){
            if (!set.contains(start - 1)){
                int maxL = 0; 
                int cur = start;
            
                while (set.contains(cur)){
                    cur++;
                    maxL++; 
                }
                res = Math.max(res, maxL);
            }
            
            
        }
        return res;
    }
}

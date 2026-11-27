class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> dup = new HashSet<>();
        for (int i : nums){
            if (!dup.add(i)) return true;
            
        }
        return false;
    }
}
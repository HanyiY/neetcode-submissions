class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> dupCheck = new HashSet<>();
        for (int num: nums){
            if (!dupCheck.add(num)) return true;
        }
        return false;
    }
}
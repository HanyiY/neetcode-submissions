class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, res, cur, 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> cur, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        int next = index + 1;
        while (next < nums.length && nums[index] == nums[next]) next++;
        dfs(nums, res, cur, next);

        cur.add(nums[index]);
        dfs(nums, res, cur, index + 1);
        cur.remove(cur.size() - 1);
        
    }
}

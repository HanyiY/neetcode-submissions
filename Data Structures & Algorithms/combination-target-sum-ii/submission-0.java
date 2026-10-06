class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, cur, res);
        return res;
    }
    
    private void dfs(int[] nums, int targetLeft, int index, List<Integer> cur, List<List<Integer>> res) {
        if (targetLeft == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if (index == nums.length) {
            return;
        }

        if (nums[index] <= targetLeft) {
            cur.add(nums[index]);
            dfs (nums, targetLeft - nums[index], index + 1, cur, res);
            cur.remove(cur.size() - 1);
        }

        int next = index + 1;
        while (next < nums.length && nums[next] == nums[index]) {
            next++;
        }
        dfs (nums, targetLeft, next, cur, res);
    }
}

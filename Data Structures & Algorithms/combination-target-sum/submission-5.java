class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(nums, target, 0, cur, res);
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

        int maxCanTake = targetLeft / nums[index];
        for (int i = 0; i <= maxCanTake; i++) {
            targetLeft -= i * nums[index];
            for (int n = 0; n < i; n++) {
                cur.add(nums[index]);
            }
            dfs(nums, targetLeft, index + 1, cur, res);
            for (int n = 0; n < i; n++) {
                cur.remove(cur.size() - 1);
            }
            targetLeft += i * nums[index];
        }
    }
}

class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(nums, 0, target, 0, cur, res);
        return res;
    }

    private void dfs(int[] nums, int curSum, int target, int index, List<Integer> cur, List<List<Integer>> res){
        if (curSum == target){
            res.add(new ArrayList<>(cur)); // Screenshot， new a ArrayList !!!
            return;
        }

        if (index == nums.length){
            return;
        }

        int maxCanTake = (target - curSum) / nums[index];
        for (int i = 0; i <= maxCanTake; i++){
            
            for (int j = 0; j < i; j++){
                cur.add(nums[index]);
            }

            dfs(nums, curSum + i * nums[index], target, index + 1, cur, res);
            
            for (int k = 0; k < i; k++){
                cur.remove(cur.size() - 1);
            }
        }

    }
}

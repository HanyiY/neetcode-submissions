class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++){
            if (nums[i] > 0)    break;
            if (i > 0 && nums[i] == nums[i - 1])    continue;
            int left = i + 1, right = n - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1])   left++;
                    while (left < right && nums[right] == nums[right + 1])  right--;
                }else if (sum > 0){
                    right--;
                }else{
                    left++;
                }          
            }
            
        }
        return res;
    }
}

// sort for two-pointer method and deduplication purpose
// after sort: nums = [-4, -1, -1, 0, 1, 2]
// fix one num: -4: left = -1 ->, right = 2 <-, find sum = 0.
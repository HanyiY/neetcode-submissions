class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int left = 0;
        int bot = matrix.length - 1;
        int right = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();

        while (left <= right && top <= bot) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }top++;

            for (int i = top; i <= bot; i++){
                res.add(matrix[i][right]);
            }right--;

            if (top <= bot){ // 必须判断 防止重复
                for (int i = right; i >= left; i--){
                    res.add(matrix[bot][i]);
                }bot--;
            }
     
            if (left <= right){ // 必须判断 防止重复
                for (int i = bot; i >= top; i--){
                    res.add(matrix[i][left]);       
                }left++;
            }
        }

        return res;
    }
}

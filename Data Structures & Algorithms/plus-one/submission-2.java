class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--){
            if (carry == 0) break;          
            int cur = digits[i];
            digits[i] = (cur + carry) % 10;
            carry = (cur + carry) / 10;
        }
        if (carry == 1){
            int[] res = new int[n + 1];
            Arrays.fill(res, 0);
            res[0] = 1;
            return res;
        }else{
            return digits;
        }
    }
}

class Solution {
    public boolean checkValidString(String s) {
        // lower/upper bound of open numbers. 
        // ( : add 1; ) : minus 1; * : lb--, ub++
        int lb = 0;
        int ub = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                lb++;
                ub++;
            }
            else if (c == ')') {
                lb--;
                ub--;
            }
            else {
                lb--; // * 全当)
                ub++; // 全当 (
            }

            //have to make sure lb is legal
            if (ub < 0) return false;
            lb = Math.max(lb, 0);
        }
        return lb == 0;
    }
}

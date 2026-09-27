/*
n = 1: 1
n = 2: 1
       2
n = 3: 1 1 1
       1 2
       2 1
n = 4: 1 1 1 1
       1 1 2
       1 2 1
       2 1 1
       2 2 



*/
class Solution {
    public int climbStairs(int n) {
        

        if (n == 1) return 1;
        if (n == 2) return 2;
        int a = 1;
        int b = 2;
        int c = 0;
        for (int i = 2; i < n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}

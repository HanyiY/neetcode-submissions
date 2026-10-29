class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 1;
        for (int pile: piles) {
            max = Math.max(pile, max);
        }
        int times = h / piles.length; // [3] h = 2 ub = 3 / 2 + 1 = 2 
        int ubSpeed = max / times + 100;  // n * log (max / h * n)
        int lbSpeed = 1;
        while (lbSpeed < ubSpeed) {
            // 
            int midSpeed = lbSpeed + (ubSpeed - lbSpeed) / 2;
            if (eatAll(midSpeed, piles, h)) {
                ubSpeed = midSpeed;
            }else{
                lbSpeed = midSpeed + 1;
            }
        }
        return lbSpeed;
    }

    private boolean eatAll(int speed, int[] piles, int h) {
        int totalTime = 0;
        for (int pile: piles) {
            int curTime = pile / speed;
            if (pile % speed > 0) curTime++;
            totalTime += curTime;
        }
        return totalTime <= h;
    }
}

/*
1 3 4 2
1 2 2 1

rate 1 -> 2 -> 3 ... max
O(kn)

-

1 ... mid ... max 


[1, 4, 3, 2]    h = 4: k = 4 (1st largest)
                h = 5: k = 3 (2nd largest)
                h = 6 - 9: k = 2 (3rd largest)
                h = 10: k = 1 (4th largest)
*/


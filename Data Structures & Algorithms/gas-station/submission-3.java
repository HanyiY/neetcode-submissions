class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }
        int remain = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            remain += (gas[i] - cost[i]);
            if (remain < 0) {
                remain = 0;
                index = i + 1;
            }
        }
        return index;
    }
}

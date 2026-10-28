class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int[] newTemp =  new int[] {temperatures[i], i};
            while (!stack.isEmpty() && temperatures[i] > stack.peek()[0]) {
                int[] cur = stack.pollFirst();
                res[cur[1]] = newTemp[1] - cur[1];
            }
            stack.offerFirst(newTemp);   
        }

        return res;
    }
}

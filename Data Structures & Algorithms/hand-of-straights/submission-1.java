class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i : hand) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }
        Arrays.sort(hand); 

        for (int i : hand) {
            if (freqMap.get(i) == 0) continue;
            for (int j = 0; j < groupSize; j++) {
                if (!freqMap.containsKey(i+j) || freqMap.get(i + j) <= 0)    return false;
                freqMap.put((i+j), freqMap.get(i + j) - 1);
            }
        }

        return true;
    }
}

// 1 2 2 3 3 4 4 5
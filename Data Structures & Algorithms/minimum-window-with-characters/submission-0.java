class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length())    return "";
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c: t.toCharArray()) freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        
        int i = 0, j = 0;
        int minWindowSize = Integer.MAX_VALUE;
        int start = 0;

        while (j < s.length()) { // 外层 while:右指针扩张
            char right = s.charAt(j);
            if (freqMap.containsKey(right)) {
                freqMap.put(right, freqMap.get(right) - 1);
            }   

            while (allMatched(freqMap)) { // 内层 while:左指针收缩
                int curWindowSize = j - i + 1;
                if (curWindowSize < minWindowSize) {
                    minWindowSize = curWindowSize;
                    start = i;
                }
                char left = s.charAt(i);
                if (freqMap.containsKey(left)) {
                    freqMap.put(left, freqMap.get(left) + 1);
                }
                i++;
            }

            j++;
        }
        
        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(start, start + minWindowSize);
    }

    private boolean allMatched (Map<Character, Integer> freqMap) {
        for (int val: freqMap.values()) {
            if (val > 0) return false;
        }
        return true;
    }
}

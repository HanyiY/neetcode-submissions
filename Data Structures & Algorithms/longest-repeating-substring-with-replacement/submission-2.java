class Solution {
    public int characterReplacement(String s, int k) {
        int slow = 0, fast = 0;
        int maxLen = 1;
        int maxFreq = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        while (fast < s.length()){
            freqMap.put(s.charAt(fast), freqMap.getOrDefault(s.charAt(fast), 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(s.charAt(fast)));
            while (fast - slow + 1 > k + maxFreq){
                freqMap.put(s.charAt(slow), freqMap.get(s.charAt(slow)) - 1);
                slow ++;
            }
            maxLen = Math.max(maxLen, fast - slow + 1);
            fast++;
        }
        return maxLen;
    }
}

//  AAABB


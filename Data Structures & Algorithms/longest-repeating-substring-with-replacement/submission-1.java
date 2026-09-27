class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int slow = 0;
        int fast = 0;
        int maxFreq = 0;
        int maxL = 0;
        
        while (fast < s.length()){
            count[s.charAt(fast) - 'A']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(fast) - 'A']);

            while (fast - slow + 1 - maxFreq > k){
                count[s.charAt(slow) - 'A']--;
                slow++;
            }

            maxL = Math.max(maxL, fast-slow+1);
            fast++;
        }

        return maxL;
    }
}


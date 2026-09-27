class Solution {
    public int lengthOfLongestSubstring(String s) {
        int slow = 0, fast = 0;
        int len = s.length();
        int maxLen = 0;
        Set<Character> seen = new HashSet<>();
        while (fast < len){
            while (seen.contains(s.charAt(fast))){
                seen.remove(s.charAt(slow++));
            }
            maxLen = Math.max(maxLen, fast - slow + 1);
            seen.add(s.charAt(fast++));
        }
        return maxLen;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int i = 0, j = 0;
        int maxLen = 0;
        while (j < s.length()) {
            while(seen.contains(s.charAt(j))) {
                seen.remove(s.charAt(i++)); // 哪儿oob了
            }
            seen.add(s.charAt(j++));
            maxLen = Math.max(j - i, maxLen);
            
        }
        return maxLen;
    }
}

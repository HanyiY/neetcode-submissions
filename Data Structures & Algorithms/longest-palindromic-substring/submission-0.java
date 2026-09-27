class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int longest = 1;
        for (int i = 0; i < s.length(); i++){
            int oddLen = expand(s, i, i);
            int evenLen = expand(s, i, i+1);
            int maxLen = Math.max(oddLen, evenLen);
            if (maxLen > longest){
                longest = maxLen;
                start = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(start, start + longest);
    }

    private int expand(String s, int left, int right){
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    } 
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)  return 0;
        if (s.length() == 1)  return 1;
        int maxL = 1;
        int slow = 0;
        int fast = 1;
        HashSet<Character> distinct = new HashSet<>();
        distinct.add(s.charAt(0));
        while (fast < s.length()){
            if (!distinct.contains(s.charAt(fast))){
                distinct.add(s.charAt(fast));
                maxL = Math.max(fast - slow + 1, maxL);
                fast++;
            }
            else {
                distinct.remove(s.charAt(slow++));
            }
        }
        return maxL;
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        // two pointer: l < r
        // for l and r: skip space or punctuations while l < r
        // then compare if lowercase are same
        // if not, early terminate. All pass -> true.
        // O(n), O(1)

        int l = 0, r = s.length() - 1;
        while (l < r){
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}

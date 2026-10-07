class Solution {
    private List<List<String>> res = new ArrayList<>();
    private List<String> path = new ArrayList<>();

    private boolean[][] isPalindrome;
    public List<List<String>> partition(String s) {
        int n = s.length();
        isPalindrome = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (j == i) isPalindrome[i][j] = true;
                if ((j - i <= 2 || isPalindrome[i+1][j-1]) && s.charAt(j) == s.charAt(i))   isPalindrome[i][j] = true;
            }
        }
        dfs (s, 0);
        return res;
    }

    private void dfs (String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (!isPalindrome[start] [end])   continue;
            path.add(s.substring(start, end + 1));
            dfs (s, end + 1);
            path.remove(path.size() - 1);
        }
    }

    // private boolean isPalindrome (String s, int a, int b) {
    //     while (a < b) {
    //         if (s.charAt(a) != s.charAt(b)) return false;
    //         a++;
    //         b--;
    //     }
    //     return true;
    // }
}

// abc
// a b c ab c a bc abc
// start 前面已经切好记录好了，从start开始继续枚举
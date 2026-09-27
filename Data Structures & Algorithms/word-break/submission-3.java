class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // define dp[i]: the String of first i characters is breakable?
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        Set<String> dic = new HashSet<>();
        for (String word: wordDict){
            dic.add(word);
        }
        // abc, dic: ab, c
        //   a b c
        // t f f f 
        for (int i = 1; i <= s.length(); i++){
            for (int j = 0; j < i; j++){
                if (dp[j] && dic.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}

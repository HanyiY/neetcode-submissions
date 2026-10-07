class Solution {
    private final String[] allCharacters = {"", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)   return res;
        dfs (digits, 0, sb);
        return res;
    }

    private void dfs (String digits, int i, StringBuilder sb) {
        if (i == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (char c: allCharacters[digits.charAt(i) - '0'].toCharArray()) {
            sb.append(c);
            dfs (digits, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

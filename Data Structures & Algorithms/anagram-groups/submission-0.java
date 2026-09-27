class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String newKey = Arrays.toString(count);
            res.putIfAbsent(newKey, new ArrayList<String>());
            res.get(newKey).add(s);
        }
        return new ArrayList<>(res.values());
    }
}

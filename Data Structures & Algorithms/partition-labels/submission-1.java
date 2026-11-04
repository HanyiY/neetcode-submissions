class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] lastIdx = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIdx[s.charAt(i) - 'a'] = i;
        }
        int end = 0, size = 0;
        for (int i = 0; i < s.length(); i++) {
            size++;
            end = Math.max(end, lastIdx[s.charAt(i) - 'a']);
            if (i == end) {
                res.add(size);
                size = 0;
            }
        }
        return res;
    }
}

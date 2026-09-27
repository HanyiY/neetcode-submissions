class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        
        for (char c: s1.toCharArray()){
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = left + s1.length() - 1;
        while (right < s2.length()){
            Map<Character, Integer> map2 = new HashMap<>();
            for (int i = left; i <= right; i++){
                map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
            }
            if (map1.equals(map2))  return true;
            left++;
            right++;
        }
        return false;
    }
}


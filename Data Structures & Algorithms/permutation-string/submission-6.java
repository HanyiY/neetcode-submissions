class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())  return false;
        Map<Character, Integer> map1 = new HashMap<>();
        for (char c: s1.toCharArray()){
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = left + s1.length() - 1;
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = left; i <= right; i++){
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }
        if (map1.equals(map2))  return true;

        while (right + 1 < s2.length()){
            right++;
            map2.put(s2.charAt(right), map2.getOrDefault(s2.charAt(right), 0) + 1);
            map2.put(s2.charAt(left), map2.get(s2.charAt(left)) - 1);
            if (map2.get(s2.charAt(left)) == 0) map2.remove(s2.charAt(left));
            left++; 
           
            if (map1.equals(map2))  return true;
        }
        return false;
    }
}


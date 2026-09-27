class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> closeToOpen = new HashMap<>();
        Deque<Character> stack = new ArrayDeque<>();
        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');

        for (char c: s.toCharArray()){
            if (closeToOpen.containsKey(c)){
                if (stack.peekLast() != closeToOpen.get(c)){
                    return false;
                }else{
                    stack.pollLast();
                }
            }else{
                stack.offerLast(c);
            }
        }

        return stack.isEmpty();
    }
}

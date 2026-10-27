class MinStack {
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    ArrayDeque<Integer> minStack = new ArrayDeque<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.offerFirst(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.offerFirst(val);
        }
    }
    
    public void pop() {
        int cur = stack.pollFirst();
        if (cur == minStack.peekFirst())  minStack.pollFirst();
    }
    
    public int top() {
        return stack.isEmpty()? -1 : stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

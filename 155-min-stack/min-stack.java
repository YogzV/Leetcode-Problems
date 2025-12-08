class MinStack {

    PriorityQueue<Integer> pqueue;
    ArrayList<Integer> stack;

    public MinStack() {
        stack = new ArrayList<>();
        pqueue = new PriorityQueue<>();
        
    }
    
    public void push(int val) {
        stack.add(val);
        pqueue.offer(val);
    }
    
    public void pop() {
        int val  = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        pqueue.remove(val);
    }
    
    public int top() {
        return stack.get(stack.size()-1);
    }
    
    public int getMin() {
        return pqueue.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
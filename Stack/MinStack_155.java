class MinStack {

    private Stack<Integer> st;
    private Stack<Integer> rt;

    public MinStack() {
        this.st = new Stack<>();
        this.rt = new Stack<>();
    }
    
    public void push(int val) {
        
        st.push(val);

        if(rt.isEmpty() || val < rt.peek())
            rt.push(val);

        else
            rt.push(rt.peek());
    }
    
    public void pop() {
        st.pop();
        rt.pop();
    }
    
    public int top() {
        
        return st.peek();
    }
    
    public int getMin() {
        return rt.peek();
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

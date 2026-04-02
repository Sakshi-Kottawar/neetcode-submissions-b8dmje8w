class MinStack {
    Stack<Integer> st;
    Stack<Integer> st1;
    public MinStack() {
    st=new Stack();
    st1=new Stack();
    }
    
    public void push(int val) {
        st.push(val);
        if(st1.isEmpty() || val<=(st1.peek())){
            st1.push(val);
        }
    }
    
    public void pop() {
        if(st.isEmpty())return;
        int val=st.pop();
        if(!st1.isEmpty() && val==st1.peek()){
            st1.pop();
        }
    }
    
    public int top() {
        // if(!st.isEmpty())
            return st.peek();
        // return 0;
    }
    
    public int getMin() {
        // if(!st1.isEmpty())
            return st1.peek();
        // return 0;    
        }
}

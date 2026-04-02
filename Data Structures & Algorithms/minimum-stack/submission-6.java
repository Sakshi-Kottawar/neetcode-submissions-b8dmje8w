class MinStack {
    Stack<Long> st;
    long min=0;
    public MinStack() {
    st=new Stack();
    }
    
    public void push(int val) {
        long v =val;
        if(st.isEmpty()){
            st.push(v);
            min=v;    
        }
        else if(!st.isEmpty() && v>=min){
            st.push(v);
        }
        else if(v<=min){
            st.push(2*v-min);
            min=v;
        }
        
    }
    
    public void pop() {
        if(st.isEmpty())return;
        if(st.peek()>min){
            st.pop();
            return;
        }
        long tmp=st.pop();
        min=min*2-tmp;

    }
    
    public int top() {
        // if(!st.isEmpty())
        long top = st.peek();
        if (top >= min) return (int)top;
        // encoded
        return (int)min;        
    }
    
    public int getMin() {
            return (int)min; 
        }
}

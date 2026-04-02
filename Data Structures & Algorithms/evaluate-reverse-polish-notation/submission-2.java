class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        Set<String> opp = new HashSet<>(Arrays.asList("-","+","*","/"));

        for(int i=0;i<tokens.length;i++){
            if(opp.contains(tokens[i])){
                if(!st.isEmpty() && st.size()>=2){
                    int b=st.pop();
                    int a=st.pop();
                    int result=0;
                    switch (tokens[i]) {
                        case "+": 
                            result = a + b;
                            break;
                        case "-": 
                            result = a - b; 
                            break;
                        case "*": 
                            result = a * b;
                            break;
                        case "/":
                            if(b!=0)
                                result = a / b;
                             break;
                        default: throw new RuntimeException("Unknown operator");
                    }  
                    st.push(result);
              }
            }else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
}

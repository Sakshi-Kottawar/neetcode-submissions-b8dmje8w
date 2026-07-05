class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> st1=new Stack<>();
        Stack<Integer> st2=new Stack<>();
        int n=s.length();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==')'){
                if(st1.isEmpty() && st2.isEmpty()){
                    return false;
                }
                if(!st1.isEmpty()){
                    st1.pop();
                }else if(!st2.isEmpty()){
                    st2.pop();
                }
            }else if(ch=='('){
                st1.push(i);
            }else{
                st2.push(i);
            }
        }
        while(!st1.isEmpty() && !st2.isEmpty()){
            if(st2.peek()>st1.peek())
            {
                st1.pop();
                st2.pop();
            }else{
                return false;
            }
        }
        return st1.isEmpty()?true:false;
    }
}

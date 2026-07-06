class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();

        StringBuilder sb=new StringBuilder();
        solve(n*2,res,sb,0);
        return res;
    }

    private void solve(int n, List<String> res, StringBuilder sb,int idx){
        if(sb.length()==n){
            if(check(sb.toString()))
                res.add(sb.toString());
            return;
        }

        sb.append('(');
        solve(n,res,sb,idx+1);
        
        sb.deleteCharAt(sb.length() - 1);
        sb.append(')');
        solve(n,res,sb,idx+1);
        sb.deleteCharAt(sb.length() - 1);
    }

    private boolean check(String s){
        Stack<Character> st=new Stack<>();


        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(ch);
            }else{
                if(!st.isEmpty())
                    st.pop();
                else
                    return false;
            }
        }

        return st.isEmpty();

    }

}

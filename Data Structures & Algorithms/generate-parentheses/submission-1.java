class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();

        StringBuilder sb=new StringBuilder();
        solve(n,res,sb,0,0);
        return res;
    }

    private void solve(int n, List<String> res, StringBuilder sb,int open,int close){
        if(sb.length()==n*2){
            res.add(sb.toString());
            return;
        }

        if(open<n){
            sb.append('(');
            solve(n,res,sb,open+1,close);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close<open){
        sb.append(')');
        solve(n,res,sb,open,close+1);
        sb.deleteCharAt(sb.length() - 1);
        }
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

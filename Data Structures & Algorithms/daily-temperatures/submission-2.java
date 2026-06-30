class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] result=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty()){
                result[i]=0;
            }else if(temperatures[st.peek()]>temperatures[i]){
                result[i]=st.peek()-i;
            }else if(temperatures[st.peek()]<=temperatures[i]){
                while(!st.isEmpty() &&  temperatures[st.peek()]<=temperatures[i]){
                    st.pop();
                }
                if(st.isEmpty())
                    result[i]=0;
                else
                    result[i]=st.peek()-i;
            }
        st.push(i);   
        }
        return result;
    }
}

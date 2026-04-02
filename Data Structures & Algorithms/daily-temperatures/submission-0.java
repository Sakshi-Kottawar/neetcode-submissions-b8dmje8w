class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] result=new int[n];
        Stack<Pair> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty()){
                result[i]=0;
            }else if(st.peek().ele>temperatures[i]){
                result[i]=st.peek().index-i;
            }else if(st.peek().ele<=temperatures[i]){
                while(!st.isEmpty() &&  st.peek().ele<=temperatures[i]){
                    st.pop();
                }
                if(st.isEmpty())
                    result[i]=0;
                else
                    result[i]=st.peek().index-i;
            }
        st.push(new Pair(temperatures[i],i));   
        }
        return result;
    }
}
class Pair{
    int ele;
    int index;
    Pair(int ele,int index){
        this.ele=ele;
        this.index=index;
    }
}

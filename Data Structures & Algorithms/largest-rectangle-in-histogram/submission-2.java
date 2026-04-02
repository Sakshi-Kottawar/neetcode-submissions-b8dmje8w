class Solution {
    public int largestRectangleArea(int[] heights) {
        //find nearest smaller left
        int n=heights.length;
        if(n==1)
            return heights[0];
        int left[]=new int[n];
        int right[]=new int[n];
        
        Stack<Integer> s=new Stack<>();
        Stack<Integer> st=new Stack<>();

        //NSL
        for(int i=0;i<n;i++){
            if(s.isEmpty()){
                left[i]=-1;
            }else if(heights[s.peek()]<heights[i]){
                left[i]=s.peek();
            }else if(heights[s.peek()]>=heights[i]){
                while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                    s.pop();
                }
                if(s.isEmpty()){
                    left[i]=-1;
                }else{
                    left[i]=s.peek();
                }
            }
            s.push(i);
        }

        //NSR
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty()){
                right[i]=n;
            }else if(heights[st.peek()]<heights[i]){
                right[i]=st.peek();
            }else if(heights[st.peek()]>=heights[i]){
                while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    right[i]=n;
                }else{
                    right[i]=st.peek();
                }
            }
            st.push(i);
        }
        int max=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            max=Math.max(max,(right[i]-left[i]-1)*heights[i]);
        }
        return max;


    }
}

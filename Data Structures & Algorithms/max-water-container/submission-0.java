class Solution {
    public int maxArea(int[] height) {
        int max=Integer.MIN_VALUE;
        int n=height.length;
        int i=0;
        int j=height.length-1;
        while(i<j && i<n && j>=0){
            // System.out.println("value of i",i);
            // System.out.println("value of j",j);
            max=Math.max(max,Math.min(height[j],height[i])*(j-i));
            if(height[j]>height[i]){
                i++;
            }else{
                j--;
            }

        }
        return max;
        
    }
}

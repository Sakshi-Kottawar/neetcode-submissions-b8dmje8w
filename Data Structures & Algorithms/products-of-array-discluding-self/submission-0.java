class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int prefixProd[]=new int[n];
        int postfixProd[]=new int[n];
        prefixProd[0]=nums[0];
        postfixProd[n-1]=nums[n-1];

        for(int i=1;i<n;i++){
            prefixProd[i]=prefixProd[i-1]*nums[i];
        }

        for(int i=n-2;i>=0;i--){
            postfixProd[i]=postfixProd[i+1]*nums[i];
        }


        int result[]=new int[n];
        for(int i=0;i<n;i++){
            int res=1;
            if(i-1>=0){
                res*=prefixProd[i-1];
            }
            if(i+1<n)
            {
                res*=postfixProd[i+1];
            }
            result[i]=res;
        }
        return result;
    }
}  

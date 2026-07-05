class Solution {
    public boolean checkValidString(String s) {
        int leftMin=0;
        int leftMax=0;


        int n=s.length();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);


            if(ch=='('){
                leftMin+=1;
                leftMax+=1;
            }else if (ch==')'){
                leftMin-=1;
                leftMax-=1;
            }else{
                leftMin-=1;
                leftMax+=1;
            }
            if(leftMax<0){
                return false;
            }
            if(leftMin<0){
                leftMin=0;
            }
        }
        return leftMin==0?true:false;
    }
}

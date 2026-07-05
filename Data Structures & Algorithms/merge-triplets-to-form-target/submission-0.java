class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int xt=target[0];
        int yt=target[1];
        int zt=target[2];

        boolean xb=false,yb=false,zb=false;

        for(int i=0;i<triplets.length;i++){
            int x=triplets[i][0];
            int y=triplets[i][1];
            int z=triplets[i][2];

            if(x>xt || y>yt || z>zt)continue;

            if(x==xt)xb=true;
            if(y==yt)yb=true;
            if(z==zt)zb=true;
        }
        return xb && yb && zb;
    }
}

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=0;
        int totalCost=0;
        int n=gas.length;
        for(int i=0;i<n;i++){
            totalGas+=gas[i];
            totalCost+=cost[i];
        }

        if(totalCost>totalGas)return -1;


        int i=0;
        int pendingGas=0;
        int start=-1;;
        while(i<n){
            if(gas[i]+pendingGas>=cost[i]){
                if(start==-1)start=i;
                pendingGas=pendingGas+gas[i]-cost[i];
            }else{
                start=-1;
                pendingGas=0;
            }
            i++;
        }
        return start;

    }
}

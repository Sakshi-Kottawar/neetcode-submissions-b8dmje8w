class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> dq=new LinkedList<>();
        Set<String> hs=new HashSet<>();
        hs.add(target);
        dq.add(target);
        int level=0;
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));


        while(!dq.isEmpty()){
            int size=dq.size();
            for(int i=0;i<size;i++){

                String curr=dq.poll();

                if(curr.equals("0000"))return level; 

                //generate all 8 combinations
                List<String> previousStates=getAllPossiblePreviousStates(curr,deadSet,hs);
               

                for(int j=0;j<previousStates.size();j++){
                    dq.add(previousStates.get(j));
                    hs.add(previousStates.get(j));
                }
                
            }
            level++;
        }
        return -1;
    }

    private   List<String> getAllPossiblePreviousStates(String str,Set<String> deadSet,Set<String> hs){

        StringBuilder sb=new StringBuilder(str);

        List<String> res=new ArrayList<>();


        for(int i=0;i<sb.length();i++){
            char originalChar = sb.charAt(i);
            int digit = originalChar - '0'; 
            int upDigit=(digit+1)%10;
            sb.setCharAt(i, (char) (upDigit + '0'));
            String neighborUp = sb.toString(); 
            if(!hs.contains(neighborUp) && !deadSet.contains(neighborUp)){
                res.add(neighborUp);
                hs.add(neighborUp);

            }
                


            int downDigit=(digit-1+10)%10;
            sb.setCharAt(i, (char) (downDigit + '0'));
            String neighborDown = sb.toString(); 

            if(!hs.contains(neighborDown) && !deadSet.contains(neighborDown)){
                res.add(neighborDown);
                hs.add(neighborDown);

            }
                
            
            sb.setCharAt(i,originalChar);


        }

        return res;

    }
}
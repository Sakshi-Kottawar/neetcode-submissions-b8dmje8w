

class Solution {
    public List<Integer> partitionLabels(String s) {
        //storing the last occurence
        HashMap<Character,Integer> hm=new HashMap<>();

        int n=s.length();
        for(int i =n-1;i>=0;i--){
            char ch=s.charAt(i);
            if(!hm.containsKey(ch)){
                hm.put(ch,i);
            }
        }
        int i=0;
        int l=0;
        int r=0;
        List<Integer> res=new ArrayList<>();
        while(r<n-1){
            int k=l;
            r = hm.get(s.charAt(k));
            // char ch=s.charAt(k);
            while(k<=r){
             r=Math.max(r,hm.get(s.charAt(k)));
             k++;
            }
            res.add(r-l+1);
            l=r+1;
            
        }
        return res;

    }
}

/*
s = "xyxxyzbzbbisl"

l=0r=0




*/

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,Integer> hm=new HashMap<>();
        DSU dsu=new DSU(accounts.size());

        for(int i=0;i<accounts.size();i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String email=accounts.get(i).get(j);
                if(hm.containsKey(email)){
                    int previousParent=hm.get(email);
                    //merging with current parent
                    dsu.union(previousParent,i);
                }else{
                    hm.put(email,i);
                }
            }
        }


        HashMap<Integer,List<String>> accountsM=new HashMap<>();

        for(String key:hm.keySet()){
            int value=hm.get(key);
            int parent=dsu.find(value);
            if(accountsM.containsKey(parent)){
              accountsM.get(parent).add(key);
            }else{
                List<String> newList=new ArrayList<>();
                newList.add(key);
                accountsM.put(parent,newList);
            }
        }


        List<List<String>> result=new ArrayList<>();

        for(int i=0;i<accountsM.size();i++){
                result.add(new ArrayList<>());
        }
        int i=0;
        for(Integer key:accountsM.keySet()){
            result.get(i).add(accounts.get(key).get(0));
            List<String> accountList=accountsM.get(key);
            result.get(i).addAll(accountList); 
            i++;
        }

        return result;

    }
}
class DSU{
    int count;
    int[] parent;
    int[] size;

    DSU(int n){
        this.count=n;
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }

    private int find(int x){
        if(parent[x]==x)return x;
        return parent[x]=find(parent[x]);
    }

    private boolean union(int x,int y){
        int rootX=find(x);
        int rootY=find(y);
        if(rootX==rootY)return false;
        if(size[rootX]>size[rootY]){
            parent[rootY]=rootX;
            size[rootX]+=size[rootY];
        }else{
            parent[rootX]=rootY;
            size[rootY]+=size[rootX];
        }
        this.count--;
        return true;
    }
}
/*
accounts = [
    ["neet","neet@gmail.com","neet_dsa@gmail.com"],
    ["alice","alice@gmail.com"],
    ["neet","bob@gmail.com","neet@gmail.com"],
    ["neet","neetcode@gmail.com"]
]


P1-A-B
P2-C
P3-A,





*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }

        List<Integer>[] store=new List[nums.length+1];

        for (int i = 0; i < store.length; i++) {
            store[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            store[value].add(key);
        }
        int result[]=new int[k];
        int j=0;
        for(int i=(store.length-1);i>0;i--)
        {
            for(int ele:store[i]){
                result[j]=ele;
                j++;
                if(j==k) return result;
            }
        }
        return result;

    }
}

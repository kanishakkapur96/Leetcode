class Solution {
    Map<Integer,Integer> store = new HashMap<>();
    public int climbStairs(int n) {
        //base case
        if(n  == 1 || n ==2)
            return n;
        
        if(store.containsKey(n))
            return store.get(n);
        
        int ans = climbStairs(n-1)+climbStairs(n-2);
        store.put(n,ans);
        return ans;
    }
}
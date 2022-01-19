class Solution {
    Map<Integer,Integer> dp = new HashMap<>();
    public int fib(int n) {
        
        if(dp.containsKey(n)){
            return dp.get(n);
        }
        if(n == 1){
            dp.put(1,1);
            return 1;
        }
        if(n == 0){
            dp.put(0,0);
            return 0;
        }
        
        int f = fib(n-1);
        int s = fib(n-2);
        dp.put(n,f+s);
        return f+s;
        
        
    }
}
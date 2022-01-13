class Solution {
    public boolean judgeSquareSum(int c) {
        return judgeHash(c);
    }
    
    // Iteration 
    boolean judgeIteration(int c){
        int limit = (int)Math.sqrt(c);
        for(int a = 0;a<=limit;a++){
            
            if(Math.floor(Math.sqrt(c-a*a)) == Math.sqrt(c-a*a)){
                return true;
            }
        }
        return false;
    }
    
    // Hashset
    
    boolean judgeHash(int c){
        HashSet<Integer> sqrSet = new HashSet<>();
        for(int i=0;i<=Math.sqrt(c);i++){
            sqrSet.add(i*i);
        }
        
        for(Integer i :  sqrSet){
            if(sqrSet.contains(c-i)){
                return true;
            }
        }
        return false;
        
    }
    
}
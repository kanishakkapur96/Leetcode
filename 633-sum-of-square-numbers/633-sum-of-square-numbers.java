class Solution {
    public boolean judgeSquareSum(int c) {
        return judgeIteration(c);
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
    
}
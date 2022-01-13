class Solution {
    public boolean judgeSquareSum(int c) {
        return judgeBinary(c);
    }
    
    // Iteration O(sqrt(c)*log c) : Log c for sqrt operation
    boolean judgeIteration(int c){
        int limit = (int)Math.sqrt(c);
        for(int a = 0;a<=limit;a++){
            
            if(Math.floor(Math.sqrt(c-a*a)) == Math.sqrt(c-a*a)){
                return true;
            }
        }
        return false;
    }
    
    // Hashset O(sqrt(c))
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
    
    // 2 pointer approach O(sqrt(c))
    boolean judgePointer(int c){
        int left = 0, right = (int)Math.sqrt(c);
        while(left<=right){
            long sum = left*left + right*right;
            if(sum == c){
                return true;
            }else if(sum<c){
                left ++;
            }else{
                right--;
            }
        }
        return false;
       
    }
    
    // Binary search
    boolean judgeBinary(int c){
       int limit = (int)Math.sqrt(c);
       for(int a =0;a<=limit;a++){
           int b = c - (int)(a*a);
           if(binarySearch(0,limit,b))
               return true;
       }
       return false;
    }
    
    boolean binarySearch(long start,long end, int  target){
        while(start<=end){
            long mid = start + (end-start)/2;
            if(mid*mid == target){
                return true;
            }else if(mid*mid<target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return false;
    }
    
}
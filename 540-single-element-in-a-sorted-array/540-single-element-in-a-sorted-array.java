class Solution {
    public int singleNonDuplicate(int[] A) {
        int N= A.length;
         int left = 0, right = N-1;
        while(left<N && right>= 0 && left<=right){
            if(left == right){
                return A[left];
            }
            
            int mid = left+(right-left)/2;
            // If mid is even
            if(mid%2 == 0){
                if(A[mid] == A[mid+1]){
                    left = mid+2;
                }else{
                    right = mid;
                }
            }else{
                if(A[mid] == A[mid-1]){
                    left = mid+1;
                }else{
                    right = mid;
                }
            }
            
        }
        
        return -1;
    }
}
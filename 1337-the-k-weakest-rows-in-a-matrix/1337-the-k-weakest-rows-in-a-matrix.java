class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        Integer[][] simpleMat = new Integer[m][2];
        for(int i=0;i<m;i++){
            simpleMat[i][0] = countOnes(mat[i]);
            simpleMat[i][1] = i;
        }
        Arrays.sort(simpleMat, (a,b) ->{
            if(a[0] == b[0]){
                return a[1].compareTo(b[1]);
            }else{
                return a[0].compareTo(b[0]);
            }
        });
        int[] kWeakest = new int[k];
        for(int i=0;i<k;i++){
            kWeakest[i] = simpleMat[i][1];
        }
        
        return kWeakest;
    }
    
    int countOnes(int[] nums){
        int start = 0;
        int end = nums.length-1;
        int ans = -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]<1){
                end = mid-1;
            }else{
                ans = mid;
                start = mid+1;
            }
        }
        
        return ans+1;
    }
}
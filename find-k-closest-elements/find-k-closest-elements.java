
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int n = arr.length;
        int right = n-1;
        while(right - left>=k){
            int leftDiff= Math.abs(arr[left]-x);
            int rightDiff = Math.abs(arr[right]-x);
            if(leftDiff<=rightDiff){
                right--;
            }else{
                left++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=left;i<=right;i++){
            result.add(arr[i]);
        }
        return result;
    }
}
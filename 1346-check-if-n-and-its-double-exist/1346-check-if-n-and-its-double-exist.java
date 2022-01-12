class Solution {
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(map.containsKey(2*arr[i]) ||(arr[i]%2 == 0 && map.containsKey(arr[i]/2))){
                return true;
            }
            map.put(arr[i],i);
        }
        return false;
    }
}
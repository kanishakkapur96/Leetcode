class Solution {
    public int longestConsecutive(int[] arr) {
       int n = arr.length;
       HashSet<Integer> lookUp = new HashSet<>();
	   for(Integer i: arr){
	       lookUp.add(i);
	   }
	   int maxCount = 0;
	   for(int i=0;i<n;i++){
	       if(!lookUp.contains(arr[i]-1)){
	           int count = 1;
	           int current = arr[i]+1;
	           while(lookUp.contains(current)){
	               count++;
	               current++;
	           }
	           
	           maxCount = Math.max(maxCount,count);
	       }
	   }
	   return maxCount;
    }
}
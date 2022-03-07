class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if(nums.length == 0){
            if(lower == upper) result.add(lower+"");
            else result.add(lower+"->"+upper);
            
            return result;
        }
        int startIndex = searchGreaterThanEqual(nums,lower); // index of element in nums which is equal or greater
        int endIndex = searchLessThanEqual(nums,upper);// index of element in nums which is equal or smaller
        
        
        if(nums[startIndex] != lower){
            if(nums[startIndex]-1 == lower) result.add(lower+"");
            else result.add(lower+"->"+ (nums[startIndex]-1));
        }
        // add remaining
        
        int start = startIndex;
        while(start+1<=endIndex){
            int r1 = nums[start]+1;
            int r2 = nums[start+1]-1;
            
            if(r1 == r2) result.add(r1+"");
            else if(r2>r1) result.add(r1+"->"+r2);
            start++;
        }
        
        if(nums[endIndex] != upper){
            if(nums[endIndex]+1 == upper) result.add(upper+"");
            else result.add(nums[endIndex]+1+"->"+upper);
        }
        
        return result;
    }
    
    int searchGreaterThanEqual(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        int ans = -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]>target){
                ans = mid;
                end = mid-1;
            }else if(nums[mid] == target){
                return mid;
            }else{
                start = mid+1;
            }
        }
        
        return ans;
    }
    
    int searchLessThanEqual(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        int ans = -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]<target){
                ans = mid;
                start = mid+1;
            }else if(nums[mid] == target){
                return mid;
            }else{
                end = mid-1;
            }
        }
        
        return ans;
    }
}
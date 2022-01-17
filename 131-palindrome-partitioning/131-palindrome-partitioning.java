class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        generatePalindrome(s,0,new ArrayList<String>(),result);
        return result;
    }
    
    void generatePalindrome(String s, int index, List<String> path, List<List<String>> result){
        if(index == s.length()){
            result.add(new ArrayList<String>(path));
            return;
        }
        
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                path.add(s.substring(index,i+1));
                generatePalindrome(s,i+1,path,result);
                path.remove(path.size()-1);
            }
        }
    }
    
    boolean isPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        
        return true;
    }
}
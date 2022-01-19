class Solution {
    Map<Integer,Boolean> memo = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        return checkPartition(s,dict,0);
        
    }
    
    boolean checkPartition(String s, Set<String> dict, int index){
        if(index == s.length()){
            memo.put(index,true);
            return true;
        }
        if(memo.containsKey(index)){
            return memo.get(index);
        }
        for(int i = index;i<s.length();i++){
            if(dict.contains(s.substring(index,i+1))){
                if(checkPartition(s,dict,i+1)){
                    memo.put(index,true);
                    return true;
                } 
            }
        }
        memo.put(index,false);
        return false;
    }
}
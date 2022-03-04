class Solution {
    public boolean rotateString(String s, String goal) {
        Character first = goal.charAt(0);
        if(s.length()!=goal.length()) return false;
        for(int i=0;i<s.length();i++){
            
            if(s.charAt(i) == first && checkStart(i,s,goal)) return true;
        }
        
        return false;
    }
    
    boolean checkStart(int index, String s, String goal){
        int n = goal.length();
        int current = 0;
        while(current<n && s.charAt(index) == goal.charAt(current) ){
            index = (index+1)%n;
            current++;
        }
        
        if(current == n) return true;
        
        return false;
    }
}
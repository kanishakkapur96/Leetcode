class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        return say(countAndSay(n-1));
    }
    
    String say(String s){
        
        String result = "";
        int i = 0;
        
        while(i<s.length()){
            int count = 1;
            int current = i+1;
            while(current<s.length() && s.charAt(i) == s.charAt(current)){
                current++;
                count++;
            }
            result = result + count + s.charAt(i);
            i = current;
        }
        
        return result;
    }
}
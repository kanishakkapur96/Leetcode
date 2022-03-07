class Solution {
    public String removeVowels(String s) {
        String result = "";
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')){
                result = result+ s.charAt(i);
            }
        }
       
        return result;
    }
}
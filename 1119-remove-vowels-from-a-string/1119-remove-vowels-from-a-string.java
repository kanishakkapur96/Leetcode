class Solution {
    public String removeVowels(String s) {
        char[] alphabets = s.toCharArray();
        for(int i=0;i<alphabets.length;i++){
            char c = alphabets[i];
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                alphabets[i] = '#';
            }
        }
        String result = "";
        for(int i=0;i<alphabets.length;i++){
            if(alphabets[i]!='#') result = result+ alphabets[i];
        }
        return result;
    }
}
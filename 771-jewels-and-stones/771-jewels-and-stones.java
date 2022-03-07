class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        HashSet<Character> jewel = new HashSet<>();
        for(int i=0;i<jewels.length();i++) jewel.add(jewels.charAt(i));
        
        for(int i=0;i<stones.length();i++){
            if(jewel.contains(stones.charAt(i))) count++;
        }
        
        return count;
    }
}
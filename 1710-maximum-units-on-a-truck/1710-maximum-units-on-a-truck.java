class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)-> b[1]-a[1]);
        int maxUnits = 0;
        int counter = 0;
        int remaining = truckSize;
        while(remaining>0 && counter<boxTypes.length){
            int[] current = boxTypes[counter];
            int selected = Math.min(current[0],remaining);
            maxUnits += selected * current[1];
            counter++;
            remaining = remaining - selected;
        }
        
        return maxUnits;
    }
}
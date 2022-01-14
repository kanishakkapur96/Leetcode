class Solution {
    public int numberOfSteps(int num) {
        return countSteps(num);
    }
    int countSteps(int num){
        if(num == 0)
            return 0;
        
        if(num%2 ==0)
            return 1+ countSteps(num/2);
        else
            return 1+countSteps(num-1);
    }
}
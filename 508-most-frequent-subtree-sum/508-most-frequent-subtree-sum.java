/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int[] maxCount = new int[]{0};
        findSum(root,map,maxCount);
        for(Integer key : map.keySet()){
            if(map.get(key) == maxCount[0])
                res.add(key);
        }
        
        
        int[] array = new int[res.size()];
        for(int i = 0; i < res.size(); i++) array[i] = res.get(i);
        return array;
        
    }
    
    int findSum(TreeNode root, Map<Integer,Integer> map,int[] maxCount){
        if(root == null) return 0;
        int left = findSum(root.left,map,maxCount);
        int right = findSum(root.right,map,maxCount);
        
        int sum = root.val + left+ right;
        if(map.containsKey(sum)){
            map.put(sum,map.get(sum)+1);
            
        } else{
            map.put(sum,1);  
        }
        maxCount[0] = Math.max(maxCount[0],map.get(sum));
        return sum;
    }
}
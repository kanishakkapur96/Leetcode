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
        Map<Integer,List<Integer>> inverse = new HashMap<>();
        Map<Integer,Integer> map = new HashMap<>();
        findSum(root,map);
        for(Integer key : map.keySet()){
            if(inverse.containsKey(map.get(key))){
                inverse.get(map.get(key)).add(key);
            }else{
                inverse.put(map.get(key), new ArrayList<Integer>());
                inverse.get(map.get(key)).add(key);
            }
        }
        Integer maxKey = Integer.MIN_VALUE;
        for(Integer key: inverse.keySet()){
            if(key>maxKey)
                maxKey = key;
        }
        
        List<Integer> res = inverse.get(maxKey);
        int[] array = new int[res.size()];
        for(int i = 0; i < res.size(); i++) array[i] = res.get(i);
        return array;
        
    }
    
    int findSum(TreeNode root, Map<Integer,Integer> map){
        if(root == null) return 0;
        int left = findSum(root.left,map);
        int right = findSum(root.right,map);
        
        int sum = root.val + left+ right;
        if(map.containsKey(sum)) 
            map.put(sum,map.get(sum)+1);
        else
            map.put(sum,1);
        
        return sum;
    }
}
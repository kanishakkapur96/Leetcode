class TrieNode{
    char ch;
    TrieNode[] children;
    boolean isWord;

    TrieNode(char c){
        ch = c;
        children = new TrieNode[26];
        isWord = false;
    }
}
class Trie{    
    TrieNode root;
    
    Trie(){
        root = new TrieNode('#');
    }
    
    void add(String word){
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(current.children[c-'a'] == null) current.children[c-'a'] = new TrieNode(c);
            current = current.children[c-'a'];
        }
        
        current.isWord = true;
    }
    
    TrieNode search(String word){
        TrieNode current= root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(current.children[c-'a'] == null) return null;
            current = current.children[c-'a'];
        }
        
        if(!current.isWord) return null;
        return current;
    }
    
}
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie prefix = new Trie();
        for(String s:words)
            prefix.add(s);
        
        HashSet<String> result = new HashSet<>();
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited =  new boolean[n][m];
        int[][] d = new int[4][];
        d[0] = new int[]{-1,0};
        d[1] = new int[]{1,0};
        d[2] = new int[]{0,1};
        d[3] = new int[]{0,-1};
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dfs(i,j,board,"",prefix.root,visited,result, d);
            }
        }
        
        List<String> ans = new ArrayList<>(result);
        return ans;   
    }
    
    void dfs(int row, int col, char[][] board, String word, TrieNode node, boolean[][] visited, HashSet<String> result, int[][] direction){
        
        
        // Check 
        if(row<0||col<0||row>=board.length||col >= board[0].length||node.children[board[row][col]-'a'] == null||visited[row][col] == true){
            return;
        }
        char c = board[row][col];
        visited[row][col] = true;
        String newWord = word + c;
        node = node.children[c-'a'];
        if(node.isWord){
            result.add(newWord);
        }
        
        for(int[] d: direction){
            int dx = row + d[0];
            int dy = col+d[1];
            dfs(dx,dy,board,newWord,node,visited,result,direction);
        }
        
        visited[row][col] = false;
        
    }
}
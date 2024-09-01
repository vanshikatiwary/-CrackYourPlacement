  class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root ==null) return result;
        traverse(root, 0);
        return result;
    }
    
    private void traverse(TreeNode node, int level) {
        if(node == null) return;
        if(result.size() == level){
            result.add(new ArrayList<>());
        }
        
        result.get(level).add(node.val);
        traverse(node.left, level+1);
        traverse(node.right, level+1);
        
    }
}
class Solution {  //Iterative solution
    
  private boolean isLeaf(TreeNode node) {
    return node != null && node.left == null && node.right == null;
  }

  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) return 0;
    int total = 0;
    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.push(root);

    while (!queue.isEmpty()) {
      TreeNode subRoot = queue.pop();
      if (isLeaf(subRoot.left)) {
        total += subRoot.left.val;
      }
      if (subRoot.right != null)   queue.push(subRoot.right);
      if (subRoot.left != null)    queue.push(subRoot.left);
    }
    return total;
  }
}
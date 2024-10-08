class Solution {
    int k;
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return result;
    }
    
    void inorder(TreeNode root) {
        
        if(root == null)
            return ;
        
        inorder(root.left);
        if(--k == 0) {
            result = root.val;
            return;
        }
        inorder(root.right);
    }
}
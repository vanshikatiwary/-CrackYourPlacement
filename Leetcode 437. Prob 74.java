  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1); // Initialize for cases where path sum directly equals targetSum
        return dfs(root, 0L, targetSum, prefixSumCount);
    }

    private int dfs(TreeNode node, long currentSum, int targetSum, HashMap<Long, Integer> prefixSumCount) {
        if (node == null) return 0;

        currentSum += node.val;
        int count = prefixSumCount.getOrDefault(currentSum - targetSum, 0);

        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        
        // Recursively check left and right subtrees
        count += dfs(node.left, currentSum, targetSum, prefixSumCount);
        count += dfs(node.right, currentSum, targetSum, prefixSumCount);
        
        // Remove the current path sum count to ensure it doesn't affect other paths
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);
        
        return count;
    }
}
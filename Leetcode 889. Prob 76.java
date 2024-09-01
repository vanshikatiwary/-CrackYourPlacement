public class Solution {
    private int preIndex = 0;
    private int[] preorder;
    private int[] postorder;
    private HashMap<Integer, Integer> postIndexMap;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.preorder = preorder;
        this.postorder = postorder;
        this.postIndexMap = new HashMap<>();

        // Map each value to its index in postorder for quick lookup
        for (int i = 0; i < postorder.length; i++) {
            postIndexMap.put(postorder[i], i);
        }

        return construct(0, postorder.length - 1);
    }

    private TreeNode construct(int left, int right) {
        if (left > right) return null;

        TreeNode root = new TreeNode(preorder[preIndex++]);

        if (left == right) return root;

        int postIndex = postIndexMap.get(preorder[preIndex]);

        root.left = construct(left, postIndex);
        root.right = construct(postIndex + 1, right - 1);

        return root;
    }
}

package Trees;

public class TreeHeight {
    public int maxHeight(TreeNode node) {
        if(node == null) return 0;

        int leftHeight = maxHeight(node.left);
        int rightHeight = maxHeight(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}

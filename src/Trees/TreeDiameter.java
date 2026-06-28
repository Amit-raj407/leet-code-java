package Trees;

public class TreeDiameter {
    public int diameterOfBinaryTree(TreeNode node) {
        int[] diameter = new int[1];

        height(node, diameter);
        return diameter[0];
    }

    private int height(TreeNode node, int[] diameter) {
        if(node == null) return 0;

        int lh = height(node.left, diameter);
        int rh = height(node.right, diameter);

        diameter[0] = Math.max(lh, rh);

        return 1 + Math.max(lh, rh);
    }
}

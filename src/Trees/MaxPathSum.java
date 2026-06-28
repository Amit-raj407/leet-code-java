package Trees;

public class MaxPathSum {
    public int maxPathSum(TreeNode root) {
        int[] maxValue = new int[1];

        maxValue[0] = Integer.MIN_VALUE;

        maxPathDown(root, maxValue);
        return maxValue[0];
    }

    private int maxPathDown(TreeNode node, int[] maxValue) {
        if(node == null) return 0;

        int leftSum = Math.max(0, maxPathDown(node.left, maxValue));
        int rightSum = Math.max(0,maxPathDown(node.right, maxValue));

        maxValue[0] = Math.max(maxValue[0], leftSum + rightSum + node.val);

        return node.val + Math.max(leftSum, rightSum);
    }
}

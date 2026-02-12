package Trees;

public class TreeSymmetry {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true; // An empty tree is symmetric
        }
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true; // Both subtrees are empty
        }

        if(left == null || right == null) {
            return false; // One subtree is empty, the other is not
        }

        return (left.val == right.val)
                && isMirror(left.left, right.right) // Check left subtree of left with right subtree of right
                && isMirror(left.right, right.left); // Check right subtree of left with left subtree of right
    }
}

/*

💡 Core Idea
To check symmetry:
Left subtree of the root must be a mirror of the right subtree.

🌳 Check if a Binary Tree is Symmetric (Tree Symmetry)
A binary tree is symmetric if it is a mirror of itself around its center.


        1
      /   \
     2     2
    / \   / \
   3   4 4   3
This tree is symmetric because:

Left subtree is a mirror of the right subtree.

❌ Asymmetric Tree Example

        1
      /   \
     2     2
      \     \
       3     3
Not symmetric: structure is different.
 */

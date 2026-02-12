package Trees;

public class TreeMirror {
    void mirror(TreeNode root) {
        if(root == null) {
            return;
        }

        mirror(root.left);
        mirror(root.right);

        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}

/*
| Metric           | Value  |
| ---------------- | ------ |
| Time Complexity  | `O(n)` |
| Space Complexity | `O(h)` |
| (h = height of tree) |

Internally uses stack to store calls, so space complexity is O(h) due to the call stack.

      1
     / \
    2   3
   / \
  4   5
Inorder = 4 2 5 1 3

Mirror of the above tree is:

      1
     / \
    3   2
       / \
      5   4
Inorder = 3 1 5 2 4

At each level, swap the left and right children of the nodes.
We can use a recursive approach to achieve this.
 */

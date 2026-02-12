package Trees;

public class DepthFirstSearch {
    void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
}


/*

      1
     / \
    2   3
   / \
  4   5


DFS Orders:
Inorder: 4 → 2 → 5 → 1 → 3

Preorder: 1 → 2 → 4 → 5 → 3

Postorder: 4 → 5 → 2 → 3 → 1

| DFS Traversal | Order               |
| ------------- | ------------------- |
| **Preorder**  | Root → Left → Right |
| **Inorder**   | Left → Root → Right |
| **Postorder** | Left → Right → Root |


| Traversal Type | Order               | Example Purpose                 |
| -------------- | ------------------- | ------------------------------- |
| **Inorder**    | Left → Root → Right | BST: returns sorted order       |
| **Preorder**   | Root → Left → Right | Cloning tree, serialization     |
| **Postorder**  | Left → Right → Root | Deleting tree, computing height |




 */
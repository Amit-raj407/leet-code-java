package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for(int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                currentLevel.add(current.val);
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }

            result.add(currentLevel);
        }

        return result;
    }
}




/*

Input:
      1
     / \
    2   3
   / \   \
  4   5   6

Output: [[1], [2, 3], [4, 5, 6]]

Problem: Level Order Traversal
Given the root of a binary tree, return the level order traversal of its nodes' values (i.e., from left to right, level by level).

✅ Approach: BFS Using Queue
💡 Concepts:
Use a Queue<TreeNode> to process nodes level by level.

For each level:

Store its size.

Process all nodes at this level.

Add their children to the queue.

| Traversal Type     | Time Complexity | Space Complexity |
| ------------------ | --------------- | ---------------- |
| Level Order        | `O(n)`          | `O(n)`           |
| Zigzag Level Order | `O(n)`          | `O(n)`           |



 */
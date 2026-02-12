package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean leftToRight = true;

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<Integer> currentLevel = new LinkedList<>();

            for(int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                if(leftToRight) {
                    assert current != null;
                    currentLevel.addFirst(current.val);
                } else {
                    assert current != null;
                    currentLevel.addLast(current.val);
                }
                currentLevel.add(current.val);



                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }

            result.add(currentLevel);
            leftToRight = !leftToRight; // Toggle direction for next level
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

Zigzag Output: [[1], [3, 2], [4, 5, 6]]
Variation: Zigzag Level Order Traversal
Instead of always traversing left-to-right, alternate the direction on each level.
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
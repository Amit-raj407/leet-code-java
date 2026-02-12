package Trees;

import java.util.ArrayList;
import java.util.List;

public class RightViewTree {

    public void rightView(TreeNode root, int level, List<Integer> result) {
        if(root == null) {
            return;
        }

        if(level == result.size()) {
            result.add(root.val);
        }

        rightView(root.right, level + 1, result); // Right child first for right view
        rightView(root.left, level + 1, result);  // Then left child
    }

    public void Solution(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, 0, result);
        System.out.println(result);
    }
}

package Trees;

import java.util.ArrayList;
import java.util.List;

public class LeftViewTree {
    public void leftView(TreeNode root, int level, List<Integer> result) {
        if(root == null) {
            return;
        }

        if(level == result.size()) {
            result.add(root.val);
        }

        leftView(root.left, level + 1, result);
        leftView(root.right, level + 1, result);
    }

    public void Solution(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        leftView(root, 0, result);
        System.out.println(result);
    }

}

package BackToBackSWE.Graph;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102 {

    //BFS
    //Time: O(n)
    //Space: O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> currentLayer = new ArrayList<>();
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                currentLayer.add(curr.val);

                if (curr.left != null) {
                    q.offer(curr.left);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                }

            }

            result.add(currentLayer);
        }
        return result;
    }

    //DFS
    //Time: O(n)
    //Space: O(n) result list
    List<List<Integer>> result;
    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        if (root == null) return new ArrayList<>();

        result = new ArrayList<>();
        traverse(root, 0);
        return result;
    }

    private void traverse(TreeNode root, int level) {
        if (root == null) return;

        if (result.size() == level) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);

        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
    }

}

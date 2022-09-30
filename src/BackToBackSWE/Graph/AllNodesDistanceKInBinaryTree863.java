package BackToBackSWE.Graph;

import leetcode.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree863 {

    //BFS
    // Time: O(V + E), O(m + n), m: numbers of edges, n: number of nodes, m = n - 1 => O(n)
    // Space: O(n)
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> nodeParent = new HashMap<>();
        dfs(root, null, nodeParent);

        List<Integer> nodesWithDistanceK = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.add(target);
        visited.add(target);
        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                if (distance == k) {
                    nodesWithDistanceK.add(curr.val);
                }

                addNodesToQueue(curr.left, queue, visited);
                addNodesToQueue(curr.right, queue, visited);
                addNodesToQueue(nodeParent.get(curr), queue, visited);

            }
           distance++;
            if (distance > k) break;
        }

        return nodesWithDistanceK;
    }

    private void dfs(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> nodeParent) {
        if (node == null) return;

        nodeParent.put(node, parent);

        dfs(node.left, node, nodeParent);
        dfs(node.right, node, nodeParent);
    }

    private void addNodesToQueue(TreeNode node, Queue<TreeNode> queue, Set<TreeNode> visited) {
        if (node == null) return;

        if (!visited.contains(node)) {
            queue.add(node);
            visited.add(node);
        }
    }
}

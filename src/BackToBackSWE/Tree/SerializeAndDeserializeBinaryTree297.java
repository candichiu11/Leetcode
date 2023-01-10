package BackToBackSWE.Tree;

import leetcode.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree297 {

    private static final String NULL_SYMBOL = "x";
    private static final String DELIMITER = ",";

    //pre-order traversal, node / left / right
    //Time: O(n)
    //Space: O(n)
    public String serialize(TreeNode root) {
        if (root == null) return NULL_SYMBOL;

        String left = serialize(root.left);
        String right = serialize(root.right);

        return root.val + DELIMITER + left + DELIMITER + right;
    }

    //Time: O(n)
    //Space: O(n)
    public TreeNode deserialize(String s) {
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(s.split(DELIMITER)));

        return deserializeHelper(q);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {
        String node = queue.poll();
        if (node.equals(NULL_SYMBOL)) return null;

        TreeNode newNode = new TreeNode(Integer.parseInt(node));
        newNode.left = deserializeHelper(queue);
        newNode.right = deserializeHelper(queue);

        return newNode;
    }
}

package BackToBackSWE.Tree;

import leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class TreeReconstruction105 {

    //Time: O(n), n: length of the input array
    //Space: O(n)
    int preorderIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode build(int[] preorder, int[] inorder,
                       int inStart, int inEnd, Map<Integer, Integer> map) {
        //base
        if (inStart > inEnd) {
            return null;
        }

        //O(1)
        int preorderValue = preorder[preorderIndex];
        TreeNode node = new TreeNode(preorderValue);
        preorderIndex++;

        if (inStart == inEnd) {
            return node;
        }

        int inorderIndex = map.get(preorderValue);
        node.left = build(preorder, inorder, inStart, inorderIndex - 1, map);
        node.right = build(preorder, inorder, inorderIndex + 1, inEnd, map);

        return node;

    }
}

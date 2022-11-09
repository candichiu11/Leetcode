package BackToBackSWE.Tree;

import leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class TreeReconstruction105 {

    //Time: O(n), n: length of the input array
    //Space: O(n)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, 0, inorder.length - 1, inorderMap);
    }

    private TreeNode build(int[] preorder, int preIndex, int inStart, int inEnd, Map<Integer, Integer> map) {
        //base
        if (inStart > inEnd) return null;

        int preValue = preorder[preIndex];
        TreeNode node = new TreeNode(preValue);
        int indexInorder = map.get(preValue);
        int leftSize = indexInorder - inStart;

        node.left = build(preorder, preIndex + 1, inStart, indexInorder - 1, map);
        node.right = build(preorder, preIndex + leftSize + 1, indexInorder + 1, inEnd, map);

        return node;

    }
}

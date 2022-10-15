package BackToBackSWE.Graph;

import java.util.*;

public class CloneGraph133 {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    //BFS
    //Time: O(V + E), V: total vertices , E: total edges
    //Space: O(V + E)
    public Node cloneGraph(Node node) {
        // If the start node is null then we cannot do any cloning
        if (node == null) return null;

        /*
         * vertexMap: Map the original node reference to its clone
         * queue: Our queue for Breadth First Search
         */
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        // Add the start node to the queue. Give the start node a clone in the vertexMap
        queue.add(node);
        map.put(node, new Node(node.val));

        /*
         * The breadth first search continues until we have processed all vertices in
         * the original graph. We know this is done when the queue is empty
         */
        while (!queue.isEmpty()) {
            // We grab a node. We will express all of the edges coming off of this node.
            Node curr = queue.poll();

            // Iterate over all adjacent.
           for (Node neighbor : curr.neighbors) {
               // Has this neighbor been given a clone?
               if (!map.containsKey(neighbor)) {
                   /*
                    * No? Give it a mapping and add the original neighbor to the search queue so we
                    * can express its edges later
                    */
                   map.put(neighbor, new Node(neighbor.val));
                   queue.add(neighbor);
               }

               /*
                * Draw the edge from currVertex's clone to neighbor's clone. Do you see how our
                * hashtable makes this quick access possible?
                */
               map.get(curr).neighbors.add(neighbor);
           }
        }

        return map.get(node);
    }





//   // DFS
     // Time: O(N), N: total number of nodes
     // Space: O(N), we copy every node.(new space)
//    public Node cloneGraph(Node node) {
//        if (node == null) return null;
//
//        Map<Integer, Node> map = new HashMap<>();
//        return helper(node, map);
//    }
//
//    private Node helper(Node node, Map<Integer, Node> map) {
//        //base
//        if (map.containsKey(node.val)) {
//           return map.get(node.val);
//        }
//
//        Node copy = new Node(node.val);
//        map.put(node.val, copy);
//
//        for (Node neighbor : node.neighbors) {
//            copy.neighbors.add(helper(neighbor, map));
//        }
//
//        return copy;
//
//    }
}

package com.sheldon.basic.stack_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * <p>
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 * <p>
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 *  
 * <p>
 * 测试用例格式：
 * <p>
 * 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
 * <p>
 * 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
 * <p>
 * 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
 * <p>
 *
 * 示例 1：
 * <p>
 * 输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
 * 输出：[[2,4],[1,3],[2,4],[1,3]]
 * 解释：
 * 图中有 4 个节点。<br>
 * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。<br>
 * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。<br>
 * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 。<br>
 * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。<br>
 *
 */
public class CloneGraph {

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

    public Node cloneGraph01(Node node) {
        return dfs(node, new HashMap<>());
    }

    public Node dfs(Node cur, HashMap<Integer, Node> visited) {
        // 当前节点为空，返回空
        if (cur == null) {
            return null;
        }
        // 当节点已经访问过，直接返回
        if (visited.containsKey(cur.val)) {
            return visited.get(cur.val);
        }
        // 创建新的节点
        Node newNode = new Node(cur.val, new ArrayList<>());
        // 加入到已访问的节点中
        visited.put(newNode.val, newNode);
        // 遍历当前节点的邻居节点，并将其加入到新节点的邻居节点中
        for (Node neighbor : cur.neighbors) {
            newNode.neighbors.add(dfs(neighbor, visited));
        }
        return newNode;
    }

    public static void main(String[] args) {
        CloneGraph cloneGraph = new CloneGraph();
        Node node = cloneGraph.new Node(1);
        Node node1 = cloneGraph.new Node(2);
        Node node2 = cloneGraph.new Node(3);
        Node node3 = cloneGraph.new Node(4);
        node.neighbors = new ArrayList<>();
        node.neighbors.add(node1);
        node.neighbors.add(node3);
        node1.neighbors = new ArrayList<>();
        node1.neighbors.add(node);
        node1.neighbors.add(node2);
        node2.neighbors = new ArrayList<>();
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors = new ArrayList<>();
        node3.neighbors.add(node);
        node3.neighbors.add(node2);
        Node node4 = cloneGraph.cloneGraph01(node);
        System.out.println(node4);
    }
}


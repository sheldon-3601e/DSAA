package com.sheldon.basic.tree_;

class deleteNode_ {
    // 1. 没有找到删除值
    // 2. 找到 - 是叶子节点
    // 3. 找到 - 左节点为空，返回右节点
    // 4. 找到 - 右节点为空，返回左节点
    // 5. 找到 - 左右节点都不为空
    public TreeNode deleteNode(TreeNode root, int key) {
        // 没找到删除的值
        if (root == null) {
            return null;
        }
        // 找到删除的值
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                // 找到删除节点的 右节点 的 最左的节点
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                // 删除节点的 左节点 挂到 右节点的最左子节点
                cur.left = root.left;
                // 返回删除节点的 右节点 作为新的节点
                root = root.right;
                return root;
            }
        }

        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        return root;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;

        deleteNode_ deleteNode = new deleteNode_();
        TreeNode treeNode = deleteNode.deleteNode(root, 3);
        System.out.println(treeNode);
    }
}
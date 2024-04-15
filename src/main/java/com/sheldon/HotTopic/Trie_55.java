package com.sheldon.HotTopic;

/**
 * Created by sheldon
 * 208：实现 Trie (前缀树)
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */

class Trie_55 {

    class Node {
        boolean isEnd;
        Node[] children;

        public Node() {
            this.isEnd = false;
            // 存储 26 个字母
            this.children = new Node[26];
        }
    }

    private Node root;

    public Trie_55() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            // 获得当前字母的索引
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Node();
            }
            // 移动到下一个节点
            node = node.children[index];
        }
        // 标记当前节点为结束节点
        // 即到目前为止，有一个单词以该节点为终点
        node.isEnd = true;
    }

    public boolean search(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            // 获得当前字母的索引
            int index = c - 'a';
            if (node.children[index] == null) {
                // 说明当前节点为空，即不存在该单词
                return false;
            }
            // 移动到下一个节点
            node = node.children[index];
        }
        // 判断是否有这个单词
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (char c : prefix.toCharArray()) {
            // 获得当前字母的索引
            int index = c - 'a';
            if (node.children[index] == null) {
                // 说明当前节点为空，即不存在该单词
                return false;
            }
            // 移动到下一个节点
            node = node.children[index];
        }
        // 因为是寻找前缀，所以只要找到了这个节点，就说明前缀存在
        // 即使这个节点不是结束节点，也返回 true
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie_55 obj = new Trie_55();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
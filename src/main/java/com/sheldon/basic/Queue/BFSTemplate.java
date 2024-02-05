package com.sheldon.basic.Queue;

/**
 * @ClassName BFSTemplate
 * @Author 26483
 * @Date 2024/2/3 13:17
 * @Version 1.0
 * @Description TODO
 */
public class BFSTemplate {
    /**
     * BFS 模板代码
     * 如代码所示，在每一轮中，队列中的结点是等待处理的结点。
     * 在每个更外一层的 while 循环之后，我们距离根结点更远一步。变量 step 指示从根结点到我们正在访问的当前结点的距离。
     * <p>
     * int BFS(Node root, Node target) {
     *      Queue<Node> queue;  // store all nodes which are waiting to be processed
     *      int step = 0;       // number of steps neeeded from root to current node
     *      // initialize
     *      add root to queue;
     *      // BFS
     *      while (queue is not empty){
     *          step = step + 1;
     *          // iterate the nodes which are already in the queue
     *          int size = queue.size();
     *          for (int i = 0; i < size; ++i) {
     *              Node cur = the first node in queue;
     *              return step if cur is target;
     *              for (Node next : the neighbors of cur){
     *                  add next to queue;
     *              }
     *              remove the first node from queue;
     *          }
     *      }
     *      return -1;          // there is no path from root to target
     *}
     *
     *
     *
     * Return the length of the shortest path between root and target node.
     *
     * int BFS(Node root, Node target) {
     *      Queue<Node> queue;  // store all nodes which are waiting to be processed
     *      Set<Node> used;     // store all the used nodes
     *      int step = 0;       // number of steps neeeded from root to current node
     *      // initialize
     *      add root to queue;
     *      add root to used;
     *      // BFS
     *      while (queue is not empty){
     *          step = step + 1;
     *          // iterate the nodes which are already in the queue
     *          int size = queue.size();
     *          for (int i = 0; i < size; ++i) {
     *              Node cur = the first node in queue;
     *              return step if cur is target;
     *              for (Node next : the neighbors of cur){
     *                  if (next is not in used){
     *                      add next to queue;
     *                      add next to used;
     *                  }
     *              }
     *          remove the first node from queue;
     *          }
     *      }
     *      return -1;          // there is no path from root to target
     * }
     */
}
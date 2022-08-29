
class Queue {
    constructor() {
      this.head = null;
      this.tail = null;
    }
  
  
    enqueue(item) {
      let newNode = new QueueNode(item);
      if (!this.head) {
        this.head = newNode;
        this.tail = newNode;
        return this;
      }
      this.tail.next = newNode;
      this.tail = newNode;
      return this;
    }
  
  
    dequeue() {
      if (!this.head) return null;
      let output = this.head;
      this.head = this.head.next;
      output.next = null;
      if (!this.head) this.tail = null;
      return output;
    }
  
  
    front() {
      return this.head === null ? null : this.head.data;
    }
  
  
    isEmpty() {
      return this.head === null;
    }
  
  
  }
  
  /**
  reference:
  http://btv.melezinek.cz/binary-search-tree.html
   * Class to represent a Node in a Binary Search Tree (BST).
   * The properties in the constructor are how this node is 
   * connected to other nodes to form the tree. 
   * Similar to .next in a SinglyLinkedList except a BST node can
   * be connected to two other nodes. To start, new nodes are not
   * connected to any other nodes, these properties will be set 
   * after the new node is instantiated.
   */
  class BSTNode { // TreeNode , node
    constructor(data) {
      this.data = data;
      this.left = null; // a BSTNode with a smaller value
      this.right = null; 
    }
  }
  
    /**
     * Represents an ordered tree of nodes where 
     * the data of left nodes are <= to their parent and
     * the data of right nodes are > their parent's data.
     */
    class BinarySearchTree {
      constructor() {
        this.root = null;
      }
  
    /*********************** BONUS**************************
     * BFS order: horizontal rows top-down left-to-right.
     * Converts this BST into an array following Breadth First Search order.
     * Example on the fullTree var:
     * [25, 15, 50, 10, 22, 35, 70, 4, 12, 18, 24, 31, 44, 66, 90]
     * @param {Node} current The current node during the traversal of this tree.
     * @returns {Array<number>} The data of all nodes in BFS order.
     */
    toArrLevelorder(current = this.root) {
        const arr = [];
        const tempQ = new Queue();
        if (current){
            tempQ.enqueue(current);
        }
        while (!queue.isEmpty()){
            let dequeueNode = tempQ.dequeue();
            arr.push(dequeueNode.left);
            if (dequeueNode.left){
                tempQ.enqueue(dequeueNode.right);
            }
            if (dequeueNode.right){
                tempQ.enqueue(dequeueNode.right);
            }
        }
        return arr;
        // graphs
    }    
  
      
      // HELPER METHOD
      // Logs this tree horizontally with the root on the left.
    print(node = this.root, spaceCnt = 0, spaceIncr = 10) {
      if (!node) {
        return;
      }
  
      spaceCnt += spaceIncr;
      this.print(node.right, spaceCnt);
  
      console.log(
        " ".repeat(spaceCnt < spaceIncr ? 0 : spaceCnt - spaceIncr) +
          `${node.data}`
      );
  
      this.print(node.left, spaceCnt);
    }
  
    insert(newVal) {
      const node = new BSTNode(newVal);
  
      if (!this.root) {
        this.root = node;
        return this;
      }
  
      let current = this.root;
  
      while (true) {
        if (newVal <= current.data) {
          if (current.left === null) {
            current.left = node;
            return this;
          }
  
          current = current.left;
        } else {
          // newVal is greater than current.data
          if (current.right === null) {
            current.right = node;
            return this;
          }
  
          current = current.right;
        }
      }
    }
  
  
      
  }
  
  const emptyTree = new BinarySearchTree();
  const oneNodeTree = new BinarySearchTree();
  oneNodeTree.root = new BSTNode(10);
  // oneNodeTree.print()
  
  /* twoLevelTree
          root
          10
        /   \
      5     15
  */
  const twoLevelTree = new BinarySearchTree();
  twoLevelTree.root = new BSTNode(10);
  twoLevelTree.root.left = new BSTNode(5);
  twoLevelTree.root.right = new BSTNode(15);
  // twoLevelTree.print()
  
  /* threeLevelTree 
          root
          10
        /   \
      5     15
    / \    / \
  2   8  13  20
  */
  const threeLevelTree = new BinarySearchTree();
  threeLevelTree.insert(10)
  threeLevelTree.root = new BSTNode(10);
  threeLevelTree.root.left = new BSTNode(5);
  threeLevelTree.root.left.left = new BSTNode(2);
  threeLevelTree.root.left.right = new BSTNode(8);
  threeLevelTree.root.right = new BSTNode(15);
  threeLevelTree.root.right.right = new BSTNode(20);
  threeLevelTree.root.right.left = new BSTNode(13);
  threeLevelTree.print()
  /* fullTree
                      root
                  <-- 25 -->
                /            \
              15             50
            /    \         /    \
          10     22      35     70
        /   \   /  \    
      4    12  18  24  
  */
  
  
  const fullTree = new BinarySearchTree();
  fullTree
    .insert(25)
    .insert(15)
    .insert(10)
    .insert(22)
    .insert(4)
    .insert(12)
    .insert(18)
    .insert(24)
    .insert(50)
    .insert(35)
    .insert(70)
  
  
  
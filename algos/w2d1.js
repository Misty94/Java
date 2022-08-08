/**
 * Class to represent a Node in a Binary Search Tree (BST).
 * The properties in the constructor are how this node is 
 * connected to other nodes to form the tree. 
 * Similar to .next  in a SinglyLinkedList except a BST node can
 * be connected to two other nodes. To start, new nodes are not
 * connected to any other nodes, these properties will be set 
 * after the new node is instantiated.
 * reference : http://btv.melezinek.cz/binary-search-tree.html
 */
 class BSTNode {
    constructor(data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
}
/**
   * Represents an ordered tree of nodes where 
   * the data of left nodes are <= to their parent and
   * the data of nodes to the right are > their parent's data.
   */
  class BinarySearchTree {
    constructor() {
      this.root = null;
    }

    /**
     * Determines if this tree is empty.
     * @returns {boolean} Indicates if this tree is empty.
     */
    isEmpty() {
        if (this.root) return false; // if this.root is there (if it's not null)
        return true;
     }

    /**
     * Retrieves the smallest integer data from this tree.
     * - Time: O(?).
     * - Space: O(?).
     * @param {Node} current is default as root of the tree
     *    the tree is being traversed.
     * @returns {number} The smallest integer from this tree.
     */
    min(current = this.root) {
        if (!current) return null;
        while (current.left){ // while current.left is not null then
            current = current.left // current (which is orignially the root) updates to the next left value
        } // until the next left equals null & then you get out of the while loop & 
        return current.data; // return the current.data (which is the number) while just current would return the entire node
     }
    

    /**
     * Retrieves the smallest integer data from this tree.
     * - Time: O(?).
     * - Space: O(?).
     * @param {Node} current is default as root of the tree
     *    the tree is being traversed.
     * @returns {number} The smallest integer from this tree.
     */
    minRecursive(current = this.root) {
        if (!current.left) return current.data;
        return this.minRecursive(current.left);
    }

    /**
     * Retrieves the largest integer data from this tree.
     * - Time: O(?).
     * - Space: O(?).
     * @param {Node} current is default as root of the tree
     * @returns {number} The largest integer from this tree.
     */
    max(current = this.root) {
        while (current.right){
            current = current.right;
        }
        return current.data;
     }

    /**
     * Retrieves the largest integer data from this tree.
     * - Time: O(?).
     * - Space: O(?).
     * @param {Node} current is default as root of the tree
     *    the tree is being traversed.
     * @returns {number} The largest integer from this tree.
     */
    maxRecursive(current = this.root) {
        if (!current.right) return current.data;
        return this.maxRecursive(current.right);
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
  }

  const emptyTree = new BinarySearchTree();
  console.log(emptyTree.isEmpty());
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
  2   4  13  20
  */
  const threeLevelTree = new BinarySearchTree();
  threeLevelTree.root = new BSTNode(10);
  threeLevelTree.root.left = new BSTNode(5);
  threeLevelTree.root.left.left = new BSTNode(2);
  threeLevelTree.root.left.right = new BSTNode(4);
  threeLevelTree.root.right = new BSTNode(15);
  threeLevelTree.root.right.right = new BSTNode(20);
  threeLevelTree.root.right.left = new BSTNode(13);
  threeLevelTree.print()
  console.log(threeLevelTree.min());
  console.log(threeLevelTree.max());
  console.log(threeLevelTree.minRecursive());
  console.log(threeLevelTree.maxRecursive());
  /* fullTree
                      root
                  <-- 25 -->
                /            \
              15             50
            /    \         /    \
          10     22      35     70
        /   \   /  \    /  \   /  \
      4    12  18  24  31  44 66  90
  */
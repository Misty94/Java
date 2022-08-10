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
  
    /**
     * Inserts a new node with the given newVal in the right place to preserver
     * the order of this tree.
     * - Time: O(?).
     * - Space: O(?).
     * @param {number} newVal The data to be added to a new node.
     * @returns {BinarySearchTree} This tree.
     */
    insert(newVal) {
        var node = new BSTNode(newVal);
        var runner = this.root;
        if (!runner){
            this.root = node;
        }
        while (runner){ // while there is a runner (while it doesn't equal null)
            if (runner.data < newVal){ 
                if (!runner.right){
                    runner.right = node;
                    return;
                }
                runner = runner.right;
                continue // this means you can skip the rest of the while loop and go back to the start of the while loop for this turn
            }
            else if (runner.data > newVal){
                if (!runner.left){
                    runner.left = node;
                    return;
                }
                runner = runner.left;
                continue
            }
            else if (runner.data === newVal) return null;
        }
        // while (node.data > current.data){
        //     if (current.right == null){
        //         current.right = node;
        //         break;
        //     }
        //     current = this.root.right;
        // }
        // while (node.data < current.data){
        //     if (current.left == null){
        //         current.left = node;
        //         break;
        //     }
        //     current = current.left;
        // }
        // return BinarySearchTree;
    }
    
    /**
     * Inserts a new node with the given newVal in the right place to preserver
     * the order of this tree.
     * - Time: O(?).
     * - Space: O(?).
     * @param {number} newVal The data to be added to a new node.
     * @param {Node} curr The node that is currently accessed from the tree as
     *    the tree is being traversed.
     * @returns {BinarySearchTree} This tree.
     */
    insertRecursive(newVal, curr = this.root) {
        if (!curr) {
            this.root = new BSTNode(newVal);
        }
        if (curr.data < newVal){
            if(!curr.right){
                curr.right = new BSTNode(newVal);
                return;
            }
            return this.insertRecursive(newVal, curr.right);
        }
        else if (curr.data > newVal){
            if (!curr.left){
                curr.left = new BSTNode(newVal);
                return;
            }
            return this.insertRecursive(newVal, curr.left);
        }
        else if (curr.data == newVal) return null;
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
  threeLevelTree.insert(11);
  threeLevelTree.insert(21);
  threeLevelTree.insertRecursive(1);
  threeLevelTree.insertRecursive(9);
  threeLevelTree.print()
  
  // you can also chain it:
  // threeLevelTree.insert(3).insert(9).print();

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
  
  
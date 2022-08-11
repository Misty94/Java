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

      // DFS - Depth First Search (go to the last node first) InOrder PreOrder PostOrder
      // InOrder: left, root, right
  
    printInorder(curr = this.root){
      if(!curr){
        return; // when left points to null, it will get out and return
      }
      if(curr){
        this.printInorder(curr.left); // going in the fuction again but going to the left, so move to the left and then go back to the top of the function then goes back to this line and goes left again, when it eventually becomes null, it will return & move on to the console.log
        console.log(curr.data); // after it became null, it comes here and prints out the left.data, then prints out above, then goes right, then prints right, then goes back to root, then starts the next side
        this.printInorder(curr.right); // then here, and goes right (but not from the top-top, only where you left off)
      } 
    }
  
    printPreorder(curr = this.root){ // preOrder: root, left, right - used when trying to copy a tree
      if(!curr){
        return;
      }
      if(curr){
        console.log(curr.data); // visit the node first, then go left, then right
        this.printInorder(curr.left);
        this.printInorder(curr.right);
      } 
    }  
  
    printPostorder(curr = this.root){  // postOrder: left, right, root - when you try to delete a tree, you need to go to the last part first (you can't start at the root to delete it)
      if(!curr){
        return;
      }
      if(curr){
        this.printInorder(curr.left);
        this.printInorder(curr.right);
        console.log(curr.data);
      } 
    } 
      
    /**
    * Depth first search (recursive)
     * DFS Preorder: (CurrNode, Left, Right)
     * Converts this BST into an array following DFS preorder.
     * Example on the fullTree var:
     * [25, 15, 10, 4, 12, 22, 18, 24, 50, 35, 31, 44, 70, 66, 90]
     * @param {Node} node The current node during the traversal 
     * @param {Array<number>} vals The data that has been visited so far.
     * @returns {Array<number>} The vals in DFS Preorder once all nodes visited.
     */
    toArrPreorder(curr = this.root, vals = []) {
        if (!curr) return;
        if (curr){
            vals.push(curr.data);
            this.toArrPreorder(curr.left, vals);
            this.toArrPreorder(curr.right, vals);
        }
        return vals;
    }
    
    /**
     * DFS Inorder: (Left, CurrNode, Right)
     * Converts this BST into an array following DFS inorder.
     * See debugger call stack to help understand the recursion.
     * Example on the fullTree var:
     * [4, 10, 12, 15, 18, 22, 24, 25, 31, 35, 44, 50, 66, 70, 90]
     * @param {Node} node The current node during the traversal 
     * @param {Array<number>} vals The data that has been visited so far.
     * @returns {Array<number>} The vals in DFS Preorder once all nodes visited.
     */
    toArrInorder(node = this.root, vals = []) {
        if(!node) return;
        if (node){
            this.toArrInorder(node.left, vals);
            vals.push(node.data);
            this.toArrInorder(node.right, vals);
        }
        return vals;
    }
    
    /**
     * DFS Postorder (Left, Right, CurrNode)
     * Converts this BST into an array following DFS postorder.
     * Example on the fullTree var:
     * [4, 12, 10, 18, 24, 22, 15, 31, 44, 35, 66, 90, 70, 50, 25]
     * @param {Node} node The current node during the traversal 
     * @param {Array<number>} vals The data that has been visited so far.
     * @returns {Array<number>} The vals in DFS Preorder once all nodes visited.
     */
    toArrPostorder(node = this.root, vals = []) {
        if (!node) return;
        if (node){
            this.toArrPostorder(node.left, vals);
            this.toArrPostorder(node.right, vals);
            vals.push(node.data);
        }
        return vals;
    }
  
    /*********************** BONUS**************************
     * BFS order: horizontal rows top-down left-to-right. (BFS - also recursive)
     * Converts this BST into an array following Breadth First Search order.
     * Example on the fullTree var:
     * [25, 15, 50, 10, 22, 35, 70, 4, 12, 18, 24, 31, 44, 66, 90]
     * @param {Node} current The current node during the traversal of this tree.
     * @returns {Array<number>} The data of all nodes in BFS order.
     */
    toArrLevelorder(current = this.root) {}
      
      
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
  oneNodeTree.insert(10);
  // oneNodeTree.print()
  
  /* twoLevelTree
          root
          10
        /   \
      5     15
  */
  const twoLevelTree = new BinarySearchTree();
  twoLevelTree.insert(10);
  twoLevelTree.insert(5);
  twoLevelTree.insert(15);
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
  threeLevelTree.insert(10);
  threeLevelTree.insert(5);
  threeLevelTree.insert(2);
  threeLevelTree.insert(8);
  threeLevelTree.insert(15);
  threeLevelTree.insert(20);
  threeLevelTree.insert(13);
  threeLevelTree.print()
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
    .insert(31)
    .insert(44)
    .insert(66)
    .insert(90);
  console.log(fullTree.toArrPreorder());
  console.log(fullTree.toArrInorder());
  console.log(fullTree.toArrPostorder());
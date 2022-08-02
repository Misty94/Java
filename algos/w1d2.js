/** 
 * A class to represents a single item of a SinglyLinkedList that can be
 * linked to other Node instances to form a list of linked nodes.
 */
 class ListNode {
    constructor(data) {
    this.data = data;
    this.next = null;
    }
  }
  
  /**
   * SLL(Singly Linked List) 
   * keeps track of the start (head) of the list and to store all the
   * functionality (methods) that each list should have.
   */
  class SLL {
    constructor() {
      this.head = null;
    }
  
    /**
     * Determines if this list is empty.
     * @returns {boolean}
     */
    isEmpty() { // this.head
      if (this.head) {
        return false;
      }
      return true;
    }
  
    /**
     * Creates a new node with the given data and inserts it at the back of
     * this list.
     * @param {any} data The data to be added to the new node.
     * @returns {SinglyLinkedList} This list.
     */
    insertAtBack(data) {
      // Create a new node with the given value
      var newNode = new ListNode(data);
      var runner = this.head;
      while (runner.next) { // runner !== null
        // console.log(runner.data)
        runner = runner.next
      }
      // inserts it at the back of the list
      runner.next = newNode;
      // HINT: How to find the last node of a Singly Linked List?  
    }
  
    /** BONUS: 
     * Calls insertAtBack on each item of the given array.
     * - Time: O(n * m) n = list length, m = arr.length.
     * - Space: O(1) constant.
     * @param {Array<any>} vals The data for each new node.
     * @returns {SinglyLinkedList} This list.
     */
    insertAtBackMany(vals) {
    }
  
    //given
    printList() {
      if (!this.head) {
        console.log("Empty list")
      } else {
        var runner = this.head;
        while (runner) { // runner !== null
          console.log(runner.data)
          runner = runner.next
        }
  
  
      }
    }
  }
  
  // instantiate nodes
  var node1 = new ListNode(5)
  var node2 = new ListNode(6)
  var node3 = new ListNode(7)
  
  node1.next = node2 // .next points to another node (not data)
  node2.next = node3
  
  // create empty list
  var emptyList = new SLL();
  
  var list1 = new SLL();
  list1.head = node1;
  list1.insertAtBack(8)
  
  console.log(list1.printList())
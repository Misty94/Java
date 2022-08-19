class Node {
    constructor(data) {
      this.data = data
      this.next = null
      this.prev = null
    }
  }
  
  /**
   * A class to represent a doubly linked list and contain all of it's methods.
   * A doubly linked list is a singly linked list that can be traversed in both
   * directions.
   */
  class DoublyLinkedList {
    /**
     * Executed when the new keyword is used to construct a new DoublyLInkedList
     * instance that inherits these methods and properties.
     */
    constructor() {
      this.head = null
      this.tail = null
    }
  
  
    insertAtFront(data) {
      let newNode = new Node(data)
      if (!this.head) {
        this.head = newNode
        this.tail = newNode
        return this
      }
      this.head.prev = newNode
      newNode.next = this.head
      this.head = newNode
      return this
    }
  
  
    insertAtBack(data) {
      let newNode = new Node(data)
      if (!this.head) {
        this.head = newNode
        this.tail = newNode
        return this
      }
      this.tail.next = newNode
      newNode.prev = this.tail
      this.tail = newNode
      return this
    }
  
    /**
   * Inserts a new node with the given newVal after the node that has the
   * given targetVal as it's data.
   * - Time: O(?).
   * - Space: O(?).
   * @param {any} targetVal The node data to find.
   * @param {any} newVal Data for the new node.
   * @returns {boolean} Indicates if the new node was added.
   */
//   insertAfter(targetVal, newVal) {
//     let newNode = new Node(newVal);
//     if (!this.head){
//         this.head = newNode;
//         this.tail = newNode;
//         return this;
//     }
//     let fRunner = this.head;
//     let bRunner = this.tail;
//     while (fRunner){
//         if (fRunner.data == targetVal){
//             fRunner.next = newNode;
//             newNode.prev = fRunner;
//             return true;
//         } 
//         if (bRunner == targetVal){

//         }
//         else {
//             fRunner = this.next;
//             bRunner = this.prev;
//         }
//     }
//     return false;
//   }


// Solution with no Back Runner
// If you had both, while (fRunner >= bRunner)????
insertAfter(targetVal, newVal) {
    let newNode = new Node(newVal);
    if (!this.head){
        this.head = newNode;
        this.tail = newNode;
        return this;
    }
    let runner = this.head;
    while (runner.next != null){
        if (runner.data == targetVal) break;
        runner = runner.next;
    }
    newNode.next = runner.next;
    runner.next.prev = newNode;
    newNode.prev = runner;
    runner.next = newNode;
    return this;
}
  
  /**
   * Inserts a new node with the given newVal before the node that has the
   * given targetVal as it's data.
   * - Time: O(?).
   * - Space: O(?).
   * @param {any} targetVal The node data to find.
   * @param {any} newVal Data for the new node.
   * @returns {boolean} Indicates if the new node was added.
   */
  insertBefore(targetVal, newVal) {
    let newNode = new Node(newVal);
    if (!this.head){
        this.head = newNode;
        this.tail = newNode;
        return this;
    }
    let runner = this.head;
    while (runner.next != null){
        if (runner.data == targetVal) break;
        runner = runner.next;
    }
    newNode.next = runner;
    newNode.prev = runner.prev;
    runner.prev.next = newNode;
    runner.prev = newNode;
    return this;
  }
  
  
    /**
     * Determines if this list is empty.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {boolean} Indicates if this list is empty.
     */
    isEmpty() {
      return this.head === null;
    }
  
    /**
     * Converts this list to an array of the node's data.
     * - Time: O(n) linear, n = list length.
     * - Space: O(n) linear, array grows as list length increases.
     * @returns {Array<any>} All the data of the nodes.
     */
    toArray() {
      const vals = [];
      let runner = this.head;
  
      while (runner) {
        vals.push(runner.data);
        runner = runner.next;
      }
      return vals;
    }
  
    /**
     * Adds all the given items to the back of this list.
     * @param {Array<any>} items Items to be added to the back of this list.
     * @returns {DoublyLinkedList} This list.
     */
    insertAtBackMany(items = []) {
      items.forEach((item) => this.insertAtBack(item));
      return this;
    }
  }
  
  const emptyList = new DoublyLinkedList();
  
  /**************** Uncomment these test lists after insertAtBack is created. ****************/
  const testList = new DoublyLinkedList().insertAtBackMany([4, 5, 6, 7, 8, 9, 10]);
  console.log(testList.toArray())
  
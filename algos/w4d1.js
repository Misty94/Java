class Node {
    constructor(data) {
      this.data = data;
      this.next = null;
      this.prev = null
    }
  }
  /**
   * Class to represent a stack using Double linked nodes to store the stacked items.
   * Follows a LIFO (Last In First Out) order where new items are stacked on
   * top (back) and removed items are removed from the top / back.
   */
  
  class DoubleLinkedListStack {
    /**
   * The constructor is executed when instantiating a new Stack() to construct
   * a new instance.
   * @returns {Stack} This new Stack instance is returned without having to
   *    explicitly write 'return' (implicit return).
   */
    constructor() {
      this.top = null;
      this.bottom = null;
    }
  
    /**
     * Adds a new given item to the top of this stack.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @param {any} item The new item to be added to the top.
     * @returns {this} this so the method can be chained.
     */
    push(item) {
        let newNode = new Node(item); // populate Node with item & set it to a new variable
        if (this.top == null){
            this.top = newNode; 
            this.bottom = newNode;
        }
        else {
            this.top.prev = newNode;
            newNode.next = this.top;
            this.top = newNode;
        }
        return this;
     }
  
    /**
     * Removes the top item from this stack.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {any} The removed item or undefined if this stack was empty.
     */
    pop() {
        let tempNode;
        if (this.top != null){
            tempNode = this.top; // assign tempNode to the current Top
            this.top = this.top.next; // set the top node to whatever the next node is
            this.top.prev = null; // now that the top has been redefined, break the pointer
            tempNode.next = null; // break the other pointer
            return tempNode;
        }
        return this;
     }
  
    /**
     * Retrieves the top item from this stack without removing it.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {any} The top item of this stack.
     */
    peek() {
        let tempNode;
        if (this.top != null){
            tempNode = this.top;
            return tempNode;
        }
     }
  
    /**
     * Returns whether or not this stack is empty.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {boolean}
     */
    isEmpty() {
        if (this.top){
            return false;
        }
        else {
            return true;
        }
     }
  
    /**
     * Returns the size of this stack.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {number} The length.
     */
    size() {
        let size = 0;
        if (this.top && this.bottom && this.top == this.bottom){
            size++;
        }
        else if (this.top && this.bottom){
            let topRunner = this.top;
            let bottomRunner = this.bottom;
            while (topRunner && bottomRunner && topRunner != bottomRunner){
                size +=1;
                topRunner = topRunner.next;
                bottomRunner = bottomRunner.prev;
        }
            }
        return size;
     }

     // Luke's
    //  size2() {
    //     let counterTop = 0;
    //     let counterBottom = 0;
    //     if (this.isEmpty()) return counterTop;
    //     var rBottom = this.bottom;
    //     var rTop = this.top;
    //     while (rTop != rBottom.prev){
    //             rBottom = rBottom.next;
    //             if (rBottom === rTop.next){
    //                 counterTop++
    //                 break
    //             }
    //             counterBottom++;
    //             counterTop++;
    //             rTop = rTop.prev;
    //     }
    //     return counterBottom + counterTop;
    // }
  
    print() {
      console.log("top:", this.top.data);
      let r = this.top.next
      while (r.next) {
        console.log("    ", r.data);
        r = r.next;
      }
      console.log("bot:", this.bottom.data)
      return this;
    }
  }
  
  const dlls = new DoubleLinkedListStack();
  console.log("isEmpty: ", dlls.isEmpty());
  console.log("Size: ", dlls.size());
  // comment out when push is finished
  console.log("Peek item: ", dlls.peek());
  dlls.push(20).push(78).push(64).push(12).push(34);
  dlls.print();
  console.log("-----POP-----");
  dlls.pop();
  dlls.print();
  console.log("Peek item data: ", dlls.peek().data);
  console.log("Size: ", dlls.size());
//   console.log("Luke's Size: ", dlls.size2());
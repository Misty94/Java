// // class Node 
// class ListNode {
//     constructor(data) {
//       this.data = data;
//       this.next = null;
//     }
//   }
  
//   // class SLL - Singly Linked List
//   class SLL {
//     constructor() {
//       this.head = null;
//     }
  
//     insertAtBack(data) {
//       var newNode = new ListNode(data);
//       if (this.head) {
//         var runner = this.head;
//         while (runner.next) {
//           runner = runner.next;
//         }
//         runner.next = newNode;
//       } else {
//         this.head = newNode;
//       }
//     }
//     //given
//     printList() {
//       if (!this.head) {
//         console.log("Empty list");
//         return
//       }
//       var runner = this.head;
//       while (runner) {
//         console.log(runner.data);
//         runner = runner.next;
//       }
//     }
//     /**
//      * Retrieves the data of the second to last node in this list.
//      * - Time: O(?).
//      * - Space: O(?).
//      * @returns {any} The data of the second to last node or null if there is no
//      *    second to last node.
//      */
//     secondToLast() { 
//         var runner = this.head;
//         if (!runner) return null;
//         if (!runner.next) return null;
//         while (runner.next.next){
//             runner = runner.next;
//         }
//         return runner.data;
//     }

//     // Valdemar's
//     secondToLast(){
//         var chaseRunner;
//         if (!this.head || !this.head.next){
//             return null;
//         }
//         var runner = this.head;
//         while (runner.next){
//             chaseRunner = runner;
//             runner = runner.next;
//         }
//         console.log(chaseRunner.data);
//     }
  
//     /**
//      * Removes the node that has the matching given val as it's data.
//      * - Time: O(?).
//      * - Space: O(?).
//      * @param {any} val The value to compare to the node's data to find the
//      *    node to be removed.
//      * @returns {boolean} Indicates if a node was removed or not.
//      */
//     removeVal(val) { 
//         var runner = this.head;
//         var runner2 = runner.next;
//         if(!runner) return false;
//         if(runner.data === val){
//             this.head = runner.next;
//             runner.next = null;
//         }
//         while (runner2){
//             if(runner2.dat === val) break;
//             runner = runner2;
//             runner2 = runner2.next;
//             }
//         if (runner2){
//             if (runner2.data === val){
//                 runner.next = runner2.next;
//                 runner2.next = null;
//                 return true;
//             }
//         }
//         }
//     }
//     // Martin's
//     removeVal(val) {
//         var prevRunner = null;
//         var runner = this.head;
//         while (runner) {
//             if (runner.data === val) {
//                 if (!prevRunner){
//                     this.head = runner.next;
//                     runner.next = null;
//                 } else {
//                     prevRunner.next = runner.next;
//                     runner.next = null;
//                 }
//                 return true;
//             }
//             prevRunner = runner;
//             runner = runner.next;
//         }
//     }

  
//     // EXTRA
//     /**
//      * Inserts a new node before a node that has the given value as its data.
//      * - Time: O(?).
//      * - Space: O(?).
//      * @param {any} newVal The value to use for the new node that is being added.
//      * @param {any} targetVal The value to use to find the node that the newVal
//      *    should be inserted in front of.
//      * @returns {boolean} To indicate whether the node was pre-pended or not.
//      */
//     prepend(newVal, targetVal) { 

//     }
        
// //   }
  
//   var emptyList = new SLL();
  
//   var list1 = new SLL();
//   list2.insertAtBack(1);
//   list2.insertAtBack(2);
  
//   var list2 = new SLL();
//   list2.insertAtBack(1);
//   list2.insertAtBack(2);
//   list2.insertAtBack(3);
//   //       HEAD
//   // list2: (1) --> (2) --> (3) --> null
  
//   // 1) secondToLast()
//   console.log(list1.secondToLast()) // print: 1
//   console.log(list2.secondToLast()) // print: 2
//   console.log(emptyList.secondToLast())//print: null
  
//   // 2) removeVal()
//   // list1.removeVal(1)
//   // list1.printList() // print:  (2) -->  null
//   // list2.removeVal(2)
//   // list2.printList() // print: (1) --> (3) --> null
  
  
//   // 3) prepend()
//   // list1.prepend(2,54)
//   // list1.printList() // print: (54) --> (2) -->  null
//   // list2.prepend(3,76)
//   // list1.printList() // print:(1) --> (76) --> (3)-->null
  
package Lecture42;

/*
21. Merge Two Sorted Lists
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 
Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 
Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.*/

public class Merge_Two_Sorted_List {

  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  class Solution {
    // Time Complexity: O(N + M) - We iterate through both lists once.
    // Space Complexity: O(1) - We simply rewire existing nodes.
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      
      // 1. Create a "Dummy" node. 
      // This acts as a fake head so we don't have to handle the empty list logic separately.
      ListNode dummy = new ListNode(0);
      
      // 2. Create an "Anchor" (temp).
      // We need this because 'dummy' will move forward to build the list.
      // 'temp' stays at the start so we can return the result later.
      ListNode temp = dummy;

      // 3. The "Zipper" Loop
      // Run as long as BOTH lists have nodes remaining.
      while (list1 != null && list2 != null) {
        
        // Compare values to maintain sorted order
        if (list1.val < list2.val) {
          dummy.next = list1;   // Point to the smaller node (list1)
          dummy = dummy.next;   // Move our builder pointer forward
          list1 = list1.next;   // Move list1 pointer forward
        } else {
          dummy.next = list2;   // Point to the smaller node (list2)
          dummy = dummy.next;   // Move our builder pointer forward
          list2 = list2.next;   // Move list2 pointer forward
        }
      }

      // 4. Handle Leftovers
      // If one list runs out, simply attach the REMAINDER of the other list.
      // We don't need a loop here because the rest of the list is already sorted.
      if (list1 == null) {
        dummy.next = list2;
      }
      if (list2 == null) {
        dummy.next = list1;
      }

      // 5. Return the result
      // Return temp.next to skip the fake "0" node we created at the start.
      return temp.next;
    }
  }

}

package Lecture42;
/*
148. Sort List
Given the head of a linked list, return the list after sorting it in ascending order.

Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:

Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: [] 

Constraints:
The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105
 
Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?*/

public class Sort_List {
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
    public ListNode sortList(ListNode head) {
      // Base Case: If the list is empty or has only one node, it's already sorted.
      if (head == null || head.next == null) {
        return head;
      }

      // Step 1: Divide (Split the list into two halves)
      ListNode mid = middleNode(head);
      ListNode headB = mid.next; // The start of the right half
      mid.next = null; // CRITICAL: Sever the link to separate left and right halves

      // Step 2: Recurse (Sort the left half and the right half)
      ListNode list1 = sortList(head);
      ListNode list2 = sortList(headB);

      // Step 3: Conquer (Merge the sorted halves)
      return mergeTwoLists(list1, list2);
    }

    // Standard Merge Logic (Zipper Method)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      ListNode dummy = new ListNode(0);
      ListNode temp = dummy;

      while (list1 != null && list2 != null) {
        if (list1.val < list2.val) {
          dummy.next = list1;
          dummy = dummy.next;
          list1 = list1.next;
        } else {
          dummy.next = list2;
          dummy = dummy.next;
          list2 = list2.next;
        }
      }
      // Attach remaining nodes
      if (list1 == null) {
        dummy.next = list2;
      }
      if (list2 == null) {
        dummy.next = list1;
      }
      return temp.next;
    }

    // Helper: Find the middle node
    // Note: This implementation returns the *first* middle node if there are two.
    // Example: [1, 2] -> Returns 1.
    // This is crucial! If it returned 2, the split logic would fail for list size 2 
    // (left half would still be size 2, causing infinite recursion).
    public ListNode middleNode(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;
      // Check fast.next.next to stop early for even-sized lists
      while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }
      return slow;
    }
  }

}

package Lecture42;

public class Cycle_Removal_Algo {
  public class Node {
    int value; // The data stored in the node
    Node next; // Reference (pointer) to the next node in the list
  }

  // Pointers to maintain the list state
  private Node head; // Points to the very first node (start of list)
  private int size; // Keeps track of the total number of nodes
  private Node tail; // Points to the very last node (end of list)

  // Returns current size of the list
  public int size() {
    return size;
  }

  // Adds a new item to the BEGINNING of the list
  public void addfirst(int item) {
    // Step 1: Create the new node
    Node nn = new Node();
    nn.value = item;

    // Step 2: Check if list is empty
    if (size == 0) {
      // If empty, this new node is both the head and the tail
      head = nn;
      tail = nn;
      size++;
    } else {
      // Step 3: Link new node to the current head
      nn.next = head; // New node points to old head
      head = nn; // Move head pointer to the new node
      size++;
    }
  }

  // Adds a new item to the END of the list
  public void addLast(int item) {
    if (size == 0) {
      addfirst(item); // Reuse logic if list is empty
    } else {
      // Step 1: Create new node
      Node nn = new Node();
      nn.value = item;

      // Step 2: Link current tail to new node
      tail.next = nn; // Old tail points to new node

      // Step 3: Update tail pointer
      tail = nn; // Tail now points to the new last node
      size++;
    }
  }

  // Creates a cycle for testing purposes
  public void createCycle() throws Exception {
    Node temp = getNode(2); // Node at index 3
    tail.next = temp; // Creating a cycle by linking tail to node at index 2
  }

  // Helper method: returns the actual Node object at a specific index
  private Node getNode(int idx) throws Exception {
    if (idx < 0 || idx >= size) {
      throw new Exception("Index out of bound");
    }

    // Start at head and jump 'idx' times
    Node temp = head;
    for (int i = 0; i < idx; i++) {
      temp = temp.next;
    }
    return temp; // Returns the reference to the node at that index
  }

  // Prints the entire list
  public void display() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.value + "->");
      temp = temp.next; // Move to next node
    }
    System.out.println(".");
  }

  // Returns the node where Slow and Fast meet. Returns null if no cycle.
  public Node hasCycle(Node head) {
    Node slow = head;
    Node fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return slow;
      }
    }
    return null;
  }

  // Method 1: The "Naive" Approach
  // Complexity: O(N^2)
  // Logic: Iterate through the list one node at a time (start).
  // For each node, check if it is the start of the cycle by traversing the loop.
  public void removeCycle1() {
    Node meet = hasCycle(head);
    if (meet == null) {
      return; // No cycle detected
    }
    Node start = head;

    while (start != meet) {
      Node temp = meet;

      // Inner loop: Traverse the entire cycle to see if we hit 'start'
      while (temp.next != meet) {
        if (temp.next == start) {
          // Found it! 'start' is the beginning of the cycle.
          // 'temp' is the node right before it (the tail of the cycle).
          temp.next = null; // Break the cycle
          return;
        }
        temp = temp.next;
      }
      start = start.next;
    }
  }

  // Method 2: The "Length" Approach
  // Complexity: O(N)
  // Logic: Calculate cycle length (k). Move 'fast' k steps ahead. 
  // Then move both pointers. They will meet at the start of the cycle.
  public void removeCycle2() {
    Node meet = hasCycle(head);
    if (meet == null) {
      return; // No cycle detected
    }

    // Step 1: Calculate the length (count) of the loop
    int count = 1;
    Node temp = meet;
    while (temp.next != meet) {
      count++;
      temp = temp.next;
    }
    // Step 2: Place Fast pointer 'count' distance away from Head
    Node fast = head;
    for (int i = 0; i < count; i++) {
      fast = fast.next;
    }

    // Step 3: Move Slow (from head) and Fast (from k distance) simultaneously
    // until they meet at the start of the cycle
    Node slow = head;

    // We check .next because we want to stop BEFORE the start of the cycle
    // to set the next pointer to null.
    while (slow.next != fast.next) {
      slow = slow.next;
      fast = fast.next;
    }
    // Step 4: Break the cycle
    // 'fast' is currently the node immediately before the cycle start
    fast.next = null; // Break the cycle

  }

  // Method 3: Floyd's Cycle Removal (Most Efficient)
  // Complexity: O(N)
  // Logic: Uses the mathematical property that distance from Head->Start 
  // is same as Meet->Start.
  public void floyedCycleRemoval() {
    Node meet = hasCycle(head);
    if (meet == null) {
      return; // No cycle detected
    }
    Node slow = head;
    Node fast = meet;

    // Move both pointers 1 step at a time.
    // We check .next because we want to stop at the node BEFORE the cycle starts
    // (The tail of the cycle).
    while (slow.next != fast.next) {
      slow = slow.next;
      fast = fast.next;
    }
    // 'fast' is now the last node in the cycle.
    // Pointing it to null breaks the loop.
    fast.next = null; // Break the cycle

  }

  public static void main(String[] args) throws Exception {
    Cycle_Removal_Algo cl = new Cycle_Removal_Algo();
    cl.addLast(10);
    cl.addLast(20);
    cl.addLast(30);
    cl.addLast(40);
    cl.addLast(50);
    cl.addLast(60);
    cl.addLast(70);
    cl.addLast(80);
    cl.createCycle();
    //cl.removeCycle1();
    // cl.removeCycle2();
    cl.floyedCycleRemoval();
    cl.display();

  }

}

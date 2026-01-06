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

  // Prints the entire list
  public void display() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.value + "->");
      temp = temp.next; // Move to next node
    }
    System.out.println(".");
  }

  public static void main(String[] args) {
    Cycle_Removal_Algo ll = new Cycle_Removal_Algo();
    ll.addLast(10);
    ll.addLast(20);
    ll.addLast(30);
    ll.addLast(40);
    ll.addLast(50);
    ll.addLast(60);
    ll.addLast(70);
    ll.addLast(80);
    ll.display();

  }

}

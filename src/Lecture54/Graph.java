package Lecture54;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
  private HashMap<Integer, HashMap<Integer, Integer>> map;

  public Graph(int v) {
    map = new HashMap<>();
    for (int i = 1; i <= v; i++) {
      map.put(i, new HashMap<>());
    }

  }

  //adding edges to the graph
  public void AddEdge(int u, int v, int wt) {
    map.get(u).put(v, wt);
    map.get(v).put(u, wt);
  }

  //checking if edge exists in graph
  public boolean containsEdge(int u, int v) {
    return map.get(u).containsKey(v) && map.get(v).containsKey(u);
  }

  //checking if vertex exists in graph
  public boolean containsVertex(int u) {
    return map.containsKey(u);
  }

  //checking no of edges in graph
  public int noOfEdges() {
    int sum = 0;
    for (int key : map.keySet()) {
      sum += map.get(key).size();
    }
    return sum / 2;
  }

  //removing edge from graph
  public void removeEdge(int u, int v) {
    if (containsEdge(u, v)) {
      map.get(u).remove(v);
      map.get(v).remove(u);
    }

  }

  //removing vertex from graph 
  public void removeVertex(int u) {
    for (int neighbours : map.get(u).keySet()) {
      map.get(neighbours).remove(u);
    }
    map.remove(u);
  }

  //printing graph
  public void printGraph() {
    for (int key : map.keySet()) {
      System.out.println(key + " -> " + map.get(key));
    }
  }

  //checking a path between two  vertices in graph
  public boolean hasPath(int src, int dest, HashSet<Integer> visited) {
    if (src == dest) {
      return true;
    }
    visited.add(src);
    for (int neighbours : map.get(src).keySet()) {
      if (!visited.contains(neighbours)) {
        boolean ans = hasPath(neighbours, dest, visited);
        if (ans) {
          return ans;
        }
      }
    }
    visited.remove(src);
    return false;
  }

  //checking all possible paths between two nodes
  public void allPath(int src, int dest, HashSet<Integer> visited, String ans) {
    if (src == dest) {
      System.out.println(ans + src);
      return;
    }
    visited.add(src);
    for (int neighbours : map.get(src).keySet()) {
      if (!visited.contains(neighbours)) {
        allPath(neighbours, dest, visited, ans + src);
      }
    }
    visited.remove(src);
  }

  public boolean BFS(int src, int dest) {
    HashSet<Integer> visited = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();

    // INITIALIZATION: Add the starting node to the queue to kickstart the loop.
    queue.add(src);

    while (!queue.isEmpty()) {
      // 1. REMOVE (Standard BFS Step)
      // Poll retrieves and removes the head of the queue (FIFO - First In, First Out).
      int rv = queue.poll();

      // 2. IGNORE (Cycle and Duplicate Check)
      // This is crucial. Since neighbors are added blindly (see Step 5), 
      // the same node might exist multiple times in the queue. 
      // If we've seen it before, skip it to prevent infinite loops and redundant work.
      if (visited.contains(rv)) {
        continue;
      }

      // 3. MARK VISITED
      // Mark this node as processed so we don't process it again in future iterations.
      visited.add(rv);

      // 4. SELF WORK (The Logic Check)
      // If the node we just pulled out is our target, a path exists.
      if (rv == dest) {
        return true;
      }

      // 5. ADD NEIGHBORS
      // Get all direct connections from the Adjacency Map.
      // We blindly add unvisited neighbors to the queue. 
      // Note: duplicates may enter the queue here, which is why Step 2 is mandatory.
      for (int neighbour : map.get(rv).keySet()) {
        if (!visited.contains(neighbour)) {
          queue.add(neighbour);
        }
      }
    }

    // If the queue becomes empty and we haven't returned true, 
    // it means 'dest' is unreachable from 'src'.
    return false;
  }

  // Depth First Search algorithm (DFS) - Iterative Approach
  public boolean DFS(int src, int dest) {
    HashSet<Integer> visited = new HashSet<>();
    Stack<Integer> stack = new Stack<>();

    // INITIALIZATION: Push the starting node to kickstart the loop.
    stack.push(src);

    while (!stack.isEmpty()) {
      // 1. REMOVE (LIFO - Last In, First Out)
      // Pop retrieves the MOST RECENTLY added node. This is what makes it "Depth" first;
      // we keep diving deeper into the newest neighbor we found.
      int rv = stack.pop();

      // 2. IGNORE (Cycle Check)
      // If 'rv' is already in 'visited', we have reached this node before via a different path.
      // Skip it to avoid cycles and infinite loops.
      if (visited.contains(rv)) {
        continue;
      }

      // 3. MARK VISITED
      // Mark the node as processed.
      visited.add(rv);

      // 4. SELF WORK (Check Destination)
      // Check if the current node 'rv' is the destination we are looking for.
      if (rv == dest) {
        return true;
      }

      // 5. ADD NEIGHBORS (Push to Stack)
      // Iterate over all neighbors. 
      // Note: Because a Stack is LIFO, the LAST neighbor added here will be the 
      // FIRST one popped in the next iteration. 
      for (int neighbour : map.get(rv).keySet()) {
        if (!visited.contains(neighbour)) {
          stack.push(neighbour);
        }
      }
    }

    // If stack is empty and we haven't found 'dest', no path exists.
    return false;
  }

  // Breadth First Traversal (BFT)
  // Unlike standard BFS, BFT ensures EVERY node in the graph is visited,
  // even if the graph is disconnected (has separate "islands" of nodes).
  public void BFT() {
    HashSet<Integer> visited = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();

    // 0. MASTER LOOP: Iterate through EVERY node in the graph map.
    // This loop guarantees we find and process disconnected components.
    // If a node was visited in a previous traversal, we skip it here.
    for (int src : map.keySet()) {
      if (visited.contains(src)) {
        continue;
      }

      // Start BFS for this newly found component
      queue.add(src);

      while (!queue.isEmpty()) {

        // 1. REMOVE
        // Remove the node from the front of the queue (FIFO).
        int rv = queue.poll();

        // 2. IGNORE (Cycle Check)
        // If the node is already processed, skip it.
        // This handles cycles within the component and prevents infinite loops.
        if (visited.contains(rv)) {
          continue;
        }

        // 3. MARK VISITED
        // Mark the node as processed so we don't visit it again.
        visited.add(rv);

        // 4. SELF WORK
        // Perform the operation (in this case, print the node).
        System.out.print(rv + " ");

        // 5. ADD NEIGHBORS
        // Add all unvisited neighbors to the queue.
        // Note: We blindly add unvisited neighbors; duplicates are handled by step 2.
        for (int neighbour : map.get(rv).keySet()) {
          if (!visited.contains(neighbour)) {
            queue.add(neighbour);
          }
        }
      }
    }
    // New line after printing all components
    System.out.println();
  }

  // Depth First Traversal (DFT)
  // Iterative approach using a Stack.
  // Guarantees all nodes are visited, even in disconnected graphs.
  public void DFT() {
    HashSet<Integer> visited = new HashSet<>();
    Stack<Integer> stack = new Stack<>();

    // 0. MASTER LOOP: Iterate through every node in the graph map.
    // This ensures we find and process isolated "islands" (disconnected components)
    // that a single traversal starting from one node would miss.
    for (int src : map.keySet()) {

      // If this node was already visited in a previous traversal, skip it.
      if (visited.contains(src)) {
        continue;
      }

      // Start DFS for this new component
      stack.push(src);

      while (!stack.isEmpty()) {
        // 1. REMOVE (LIFO - Last In, First Out)
        // Pop the MOST RECENTLY added node. 
        // This causes the algorithm to go "deep" into the graph immediately.
        int rv = stack.pop();

        // 2. IGNORE (Cycle/Duplicate Check)
        // Since we push neighbors blindly (Step 5), the stack may contain duplicates.
        // If we have already processed this node, skip it to prevent cycles.
        if (visited.contains(rv)) {
          continue;
        }

        // 3. MARK VISITED
        // Mark the current node as processed.
        visited.add(rv);

        // 4. SELF WORK
        // Perform the operation (e.g., Print the node).
        System.out.print(rv + " ");

        // 5. ADD NEIGHBORS
        // Push unvisited neighbors to the stack.
        // CRITICAL NOTE: Because this is a Stack, the neighbors are processed in 
        // REVERSE order of how they are added here. The LAST neighbor pushed 
        // will be the FIRST one popped in the next iteration.
        for (int neighbour : map.get(rv).keySet()) {
          if (!visited.contains(neighbour)) {
            stack.push(neighbour);
          }
        }
      }
    }
    System.out.println();
  }

}

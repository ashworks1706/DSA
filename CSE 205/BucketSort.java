public class Main {
    public static void main(String[] args) {
        // Test your methods here
        Node head = null;
 
        // Adding elements to the front
        head = addAtFront(head, 10);
        head = addAtFront(head, 20);
        head = addAtFront(head, 30);
 
        // Printing the list
        printList(head); // Expected output: {30, 20, 10}
 
        // Adding elements to the end
        head = addToEnd(head, 40);
        head = addToEnd(head, 50);
 
        // Printing the list again
        printList(head); // Expected output: {30, 20, 10, 40, 50}
 
        // Getting size of the list
        System.out.println("Size: " + getSize(head)); // Expected output: Size: 5
 
        // Removing from the front
        head = removeFromFront(head);
        printList(head); // Expected output: {20, 10, 40, 50}
 
        // Removing from the end
        head = removeFromEnd(head);
        printList(head); // Expected output: {20, 10, 40}
 
        // Inserting at index
        head = insertAtIndex(head, 1, 25);
        printList(head); // Expected output: {20, 25, 10, 40}
 
        // Removing at index
        head = removeAtIndex(head, 2);
        printList(head); // Expected output: {20, 25, 40}
    }
 
    public static Node addAtFront(Node head, int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        return newNode;
    }
 
    public static void printList(Node head) {
        System.out.print("{");
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println("}");
    }
 
    public static int getSize(Node head) {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }
 
    public static Node addToEnd(Node head, int value) {
        Node newNode = new Node(value);
        if (head == null) {
            return newNode;
        }
        
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        
        current.next = newNode;
        return head;
    }
 
    public static Node removeFromFront(Node head) {
        if (head == null) {
            return null; // List is empty
        }
        
        return head.next; // Return the next node as the new head
    }
 
    public static Node removeFromEnd(Node head) {
        if (head == null || head.next == null) {
            return null; // List is empty or has only one node
        }
        
        Node current = head;
        
        while (current.next.next != null) {
            current = current.next;
        }
        
        current.next = null; // Remove the last node
        return head;
    }
 
    public static Node insertAtIndex(Node head, int index, int value) {
        if (index == 0) {
            return addAtFront(head, value); // Insert at front if index is zero
        }
 
        Node newNode = new Node(value);
        
        Node current = head;
        
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }
        
        if (current == null) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        
        newNode.next = current.next;
        
        current.next = newNode;
 
        return head;
    }
 
    public static Node removeAtIndex(Node head, int index) {
        if (index == 0) {
            return removeFromFront(head); // Remove from front if index is zero
        }
 
        Node current = head;
 
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }
 
        if (current == null || current.next == null) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
 
        current.next = current.next.next;
 
      return head;
   }
 }
 
 // Definition of the Node class
 class Node {
   int data;
   Node next;
 
   Node(int data) {
      this.data = data;
   }
 }
 
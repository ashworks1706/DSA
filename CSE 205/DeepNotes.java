public class DeepNotes {

public static void main(String[] args) {
int[] arr = {3, 5, 8, 2, 4, 7, 1, 12, 34, 99};

Node tree = convert_to_linked(arr, 0);

Node preOrderList = pre_order(tree);
Node inOrderList  = in_order(tree);
Node postOrderList = post_order(tree);

System.out.println("Preorder Traversal:");
printList(preOrderList);

System.out.println("Inorder Traversal:");
printList(inOrderList);

System.out.println("Postorder Traversal:");
printList(postOrderList);
}

// This method converts an array into a complete binary tree.
public static Node convert_to_linked(int[] arr, int index) {
if(index >= arr.length) {
return null;
}

Node node = new Node(arr[index]);
node.left = convert_to_linked(arr, 2 * index + 1);
node.right = convert_to_linked(arr, 2 * index + 2);
return node;
}

// Preorder traversal: process node, then left subtree, then right subtree.
public static Node pre_order(Node root) {
if(root == null) {
return null;
}

Node head = new Node(root.data);
Node leftList = pre_order(root.left);
Node rightList = pre_order(root.right);

head.next = concat(leftList, rightList);
return head;
}

// Inorder traversal: process left subtree, then node, then right subtree.
public static Node in_order(Node root) {
if(root == null) {
return null;
}

Node leftList = in_order(root.left);
Node mid = new Node(root.data);
Node rightList = in_order(root.right);

// Inorder: leftList -> current node -> rightList.
return concat(concat(leftList, mid), rightList);
}

// Postorder traversal: process left subtree, then right subtree, then node.
public static Node post_order(Node root) {
if(root == null) {
return null;
}

Node leftList = post_order(root.left);
Node rightList = post_order(root.right);
Node mid = new Node(root.data);

// Postorder: leftList -> rightList -> current node.
return concat(concat(leftList, rightList), mid);
}

// Helper method to concatenate two linked lists (using next pointers).
public static Node concat(Node list1, Node list2) {
if(list1 == null)
return list2;

Node temp = list1;
while(temp.next != null) {
  temp = temp.next;
}
temp.next = list2;
return list1;
}

public static void printList(Node head) {
while(head != null) {
System.out.print(head.data + " ");
head = head.next;
}
System.out.println();
}
}

class Node {
int data;
Node left; 
Node right; Node next;

public Node(int data) {
this.data = data;
this.left = null;
this.right = null;
this.next = null;
}
}



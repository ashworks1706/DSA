class Main{
    public static void main (String [] args){
        BinaryTree tree = new BinaryTree();

        tree.insert(new Node(5));
        tree.insert(new Node(51));
        tree.insert(new Node(32));
        tree.insert(new Node(212));
        tree.insert(new Node(12));
        tree.insert(new Node(1));
        tree.display();
        System.out.println(tree.search(1));
        tree.remove(1);
        tree.display();
        System.out.println(tree.search(1));
    }
}

public class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
    }
}


// a binary tree will always have left of root small and right of root larger
public class BinaryTree{
    Node root;

    public void insert(Node node){
        root = insertHelper(root, node);
    }
    private Node insertHelper(Node root, Node node){
        int data = node.data;
        if(root == null){
            root = node;
            return root;
        }
        else if(data<root.data){
            root.left = insertHelper(root.left, node);
        }
        else{
            root.right = insertHelper(root.right, node);
        }
        return root;
    }
    public void display(){
        displayHelper(root);   
    }
    public void displayHelper(Node root){
        
        if(root!=null){
            displayHelper(root.left);
            System.out.println(root.data);
            displayHelper(root.right);
        }
    }
    public boolean search(int data){
        return searchHelper(root,data);
    }
    private boolean searchHelper(Node root, int data){
        if(root==null){
            return false;
        }
        else if(root.data == data){
            return true;
        }
        else if(data<root.data){
            return searchHelper(root.left, data);
        }
        else{
            return searchHelper(root.right, data);
        }

    }
    
    public Node remove(int data){
        if(search(data)){
            return removeHelper(root, data);
        }
        else{
            System.out.println("data not found");
            return root;
        }
    }
    private Node removeHelper(Node root, int data){
        if(root == null){
            return root;
        }
        
        else if(data < root.data){
            root.left = removeHelper(root.left, data);
        }
        else if(data > root.data){
            root.right = removeHelper(root.right, data);
        }
        else{
            if(root.left == null && root.right == null){
                root = null;
            }
            else if(root.right != null){
                // find successor 
                root.data = successor(root);
                root.right = removeHelper(root.right, root.data);
            }
            else{
                // find predecessor
                root.data = predecessor(root);
                root.left = removeHelper(root.left, root.data);
            }
        }
    
        return root;
    }
    private int successor(Node root){ // finding the least value below the right child of his root node

        root = root.right;
        while(root.left!=null){
            root = root.left;
        }
        return root.data;
        
    }
    private int predecessor(Node root){
        // finding the least value below the left child of his root node
        root = root.left;
        while(root.right!=null){
            root = root.right;
        }
        return root.data;
    }
}


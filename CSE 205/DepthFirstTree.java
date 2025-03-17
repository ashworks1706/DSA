import java.util.*;

class DepthFirstTree {
    static class Node {
        int data;
        List<Node> children;

        Node(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }

        void addChild(Node child) {
            children.add(child);
        }
    }

    Node root;

    DepthFirstTree(int rootData) {
        root = new Node(rootData);
    }

    void dfs(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");

        for (Node child : node.children) {
            dfs(child);
        }
    }

    public static void main(String[] args) {
        DepthFirstTree tree = new DepthFirstTree(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        tree.root.addChild(node2);
        tree.root.addChild(node3);
        node2.addChild(node4);
        node2.addChild(node5);

        System.out.println("Depth First Search traversal of the tree:");
        tree.dfs(tree.root);
    }
}
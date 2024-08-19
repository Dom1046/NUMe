package dfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Main2 {
    class Node {
        private int item;
        private Node node;
        private boolean marked;
        private List<Node> adjacent;

        public Node(int item) {
            this.item = item;
            this.marked = false;
            adjacent = new LinkedList<>();
        }
    }

    private Node[] nodes;

    public Main2(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    public void addEdge(int a, int b) {
        Node n1 = nodes[a];
        Node n2 = nodes[b];
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }
    public void addEdge(int a, int b,int c) {
        Node n1 = nodes[a];
        Node n2 = nodes[b];
        Node n3 = nodes[c];
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }if (!n1.adjacent.contains(n3)) {
            n1.adjacent.add(n3);
        }
        if (!n2.adjacent.contains(n3)) {
            n2.adjacent.add(n3);
        }if (!n3.adjacent.contains(n1)) {
            n3.adjacent.add(n1);
        }
        if (!n3.adjacent.contains(n2)) {
            n3.adjacent.add(n2);
        }
    }
    void dfs(int a) {
        Node root = nodes[a];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.marked = true;
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            for (Node r : n.adjacent) {
                if (!r.marked) {
                    r.marked = true;
                    stack.push(r);
                }
            } visit(n);
        }
    }

    void dfs() {
        dfs(0);
    }
    void bfs(int a) {
        Node root = nodes[a];
        Queue<Node> stack = new LinkedList<>();
        stack.offer(root);
        root.marked = true;
        while (!stack.isEmpty()) {
            Node n = stack.poll();
            for (Node r : n.adjacent) {
                if (!r.marked) {
                    r.marked = true;
                    stack.offer(r);
                }
            } visit(n);
        }
    }

    void visit(Node r) {
        System.out.print(r.item+" ");
    }

    public static void main(String[] args) {
        Main2 test = new Main2(7);
        test.addEdge(4, 5);
        test.addEdge(5, 1);
        test.addEdge(1, 2);
        test.addEdge(1, 3);
        test.addEdge(1, 4);
        test.addEdge(2, 4);
        test.addEdge(3, 4);
        test.dfs(1);
    }
}


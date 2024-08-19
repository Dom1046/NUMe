package codeTest;

import java.util.LinkedList;
import java.util.Stack;

public class CodeTest12 {
    class Graph {
        private int count = 0;

        class Node {
            int data;
            LinkedList<Node> adjacent;
            boolean marked;

            Node(int data) {
                this.data = data;
                this.marked = false;
                adjacent = new LinkedList<>();
            }
        }

        Node[] nodes;

        Graph(int size) {
            nodes = new Node[size];
            for (int i = 0; i < size; i++) {
                nodes[i] = new Node(i);
            }
        }

        void addEdge(int i1, int i2) {
            Node n1 = nodes[i1];
            Node n2 = nodes[i2];
            if (!n1.adjacent.contains(n2)) {
                n1.adjacent.add(n2);
            }
            if (!n2.adjacent.contains(n1)) {
                n2.adjacent.add(n1);
            }
        }

        void dfs() {
            dfs(1);
        }

        void dfs(int idx) {
            Node root = nodes[idx];
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            root.marked = true;
            while (!stack.isEmpty()) {
                Node r = stack.pop();
                for (Node n : r.adjacent) {
                    if (n.marked == false) {
                        n.marked = true;
                        stack.push(n);
                    }
                }
                count++;
            }
        }

        public int solution(int n, int[][] edge) {
            Graph graph = new Graph(n);

            for (int i = 0; i < edge.length; i++) {
                int node1 = edge[i][0];
                int node2 = edge[i][1];
                graph.addEdge(node1 - 1, node2 - 1);
            }
            dfs();

            return graph.count;
        }
    }
}
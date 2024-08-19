package codeTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
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

    Main(int size) {
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

    void addEdge(int i1, int i2, int i3) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        Node n3 = nodes[i3];
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n1.adjacent.contains(n3)) {
            n1.adjacent.add(n3);
        }
        if (!n3.adjacent.contains(n2)) {
            n3.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
        if (!n2.adjacent.contains(n3)) {
            n2.adjacent.add(n3);
        }
        if (!n3.adjacent.contains(n1)) {
            n3.adjacent.add(n1);
        }
    }

    void dfs() {
        dfs(0);
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
            visit(r);
        }
    }

    void bfs() {
        bfs(0);
    }

    void bfs(int idx) {
        Node root = nodes[idx];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        root.marked = true;
        while (!queue.isEmpty()) {
            Node r = queue.poll();
            for (Node n : r.adjacent) {
                if (n.marked == false) {
                    n.marked = true;
                    queue.offer(n);
                }
            }
            visit(r);
        }
    }

    void dfsR(Node r) {
        if (r == null) return;
        r.marked = true;
        visit(r);
        for (Node n : r.adjacent) {
            if (n.marked == false) {
                dfsR(n);
            }
        }
    }

    void dfsR(int index) {
        Node r = nodes[index];
        dfsR(r);
    }

    void dfsR() {
        dfsR(0);
    }

    void visit(Node n) {
        System.out.print(n.data + " ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken()); // 노드의 수
        int edgeCount = Integer.parseInt(st.nextToken()); // 간선의 수
        int startNode = Integer.parseInt(st.nextToken()) - 1; // 탐색을 시작할 노드 (인덱스는 0부터 시작하므로 -1)

        Main graph = new Main(nodeCount);

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1; // 첫 번째 노드
            int v = Integer.parseInt(st.nextToken()) - 1; // 두 번째 노드
            graph.addEdge(u, v);
        }

        System.out.print("DFS: ");
        graph.dfs(startNode); // 시작 노드부터 DFS 수행
        System.out.println();

        // 모든 노드의 marked 상태 초기화
        for (int i = 0; i < nodeCount; i++) {
            graph.nodes[i].marked = false;
        }

        System.out.print("BFS: ");
        graph.bfs(startNode); // 시작 노드부터 BFS 수행
        System.out.println();
    }
}

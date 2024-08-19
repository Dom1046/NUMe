package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    class Node implements Comparable<Node> {
        int data;
        LinkedList<Node> adjacent;
        boolean marked;

        Node(int data) {
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<>();
        }

        @Override
        public int compareTo(Node other) {
            return this.data - other.data;
        }
    }

    Node[] nodes;

    Main(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i + 1);  // 노드 번호가 1부터 시작하므로 i+1
        }
    }

    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1 - 1];
        Node n2 = nodes[i2 - 1];
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
        // 정점 번호가 작은 것부터 방문하기 위해 인접 리스트 정렬
        Collections.sort(n1.adjacent);
        Collections.sort(n2.adjacent);
    }

    void dfs(int idx) {
        Node root = nodes[idx - 1];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.marked = true;
        while (!stack.isEmpty()) {
            Node r = stack.pop();
            visit(r);
            for (Node n : r.adjacent) {
                if (!n.marked) {
                    n.marked = true;
                    stack.push(n);
                }
            }
        }
    }

    void bfs(int idx) {
        Node root = nodes[idx - 1];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        root.marked = true;
        while (!queue.isEmpty()) {
            Node r = queue.poll();
            visit(r);
            for (Node n : r.adjacent) {
                if (!n.marked) {
                    n.marked = true;
                    queue.offer(n);
                }
            }
        }
    }

    void visit(Node n) {
        System.out.print(n.data + " ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken()); // 노드의 수
        int edgeCount = Integer.parseInt(st.nextToken()); // 간선의 수
        int startNode = Integer.parseInt(st.nextToken()); // 시작 노드

        Main graph = new Main(nodeCount);

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.addEdge(u, v);
        }

        // DFS 출력
        graph.dfs(startNode);
        System.out.println();

        // BFS 출력을 위해 모든 노드의 marked 상태 초기화
        for (int i = 0; i < nodeCount; i++) {
            graph.nodes[i].marked = false;
        }

        // BFS 출력
        graph.bfs(startNode);
        System.out.println();
    }
}

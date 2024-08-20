package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Graph graph = new Graph(a);

        for (int i = 0; i < b; i++) {
            st = new StringTokenizer(br.readLine());
            graph.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        graph.dfs(c);
        System.out.println(graph.sb);

        graph.cleanTrue(graph.nodes);

        graph.bfs(c);
        System.out.println(graph.sb);
    }
}

class Graph {
    StringBuilder sb = new StringBuilder();

    class Node implements Comparable<Node> {
        int data;
        boolean marked;
        LinkedList<Node> adjacent;

        public Node(int data) {
            this.data = data;
            marked = false;
            adjacent = new LinkedList<Node>();
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(data, o.data);
        }
    }

    Node[] nodes;

    public Graph(int num) {
        nodes = new Node[num + 1];
        for (int i = 1; i <= num; i++) {
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

    public void dfs(int a) {
        Node root = nodes[a];
        root.marked = true;
        visit(a);
        Collections.sort(root.adjacent);
        for (int i = 0; i < root.adjacent.size(); i++) {
            if (!root.adjacent.get(i).marked) {
                root.adjacent.get(i).marked = true;
                dfs(root.adjacent.get(i).data);
            }
        }
    }

    public void dfs() {
        dfs(0);
    }

    public void bfs(int a) {
        sb.delete(0, sb.length());
        Node root = nodes[a];
        Queue<Node> queue = new LinkedList<>();
        root.marked = true;
        queue.offer(root);
        Collections.sort(root.adjacent);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visit(node.data);
            for (Node r : node.adjacent) {
                if (!r.marked) {
                    r.marked = true;
                    queue.offer(r);
                }
            }
        }
    }

    public void cleanTrue(Node[] arr) {

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != null) {
                arr[i].marked = false;
                for (int j = 1; j < arr[i].adjacent.size()+1; j++) {
                    if (arr[i].adjacent != null) {
                        arr[i].adjacent.get(j-1).marked = false;
                    }
                }
            }
        }
    }

    public void visit(int num) {
        sb.append(num).append(" ");
    }
}
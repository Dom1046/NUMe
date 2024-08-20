//package dfs;
//
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Stack;
//import java.util.StringTokenizer;
//
//public class Main3 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        Graph graph = new Graph(Integer.parseInt(st.nextToken()));
//
//        int lineNm = Integer.parseInt(st.nextToken());
//        int startNum = Integer.parseInt(st.nextToken());
//
//        for (int i = 0; i < lineNm; i++) {
//            st = new StringTokenizer(br.readLine());
//            graph.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
//        }
//        graph.dfs(startNum);
//        System.out.println();
//        graph.bfs(startNum);
//    }
//}
//
//class Graph {
//    class Node {
//        int data;
//        boolean marked;
//        LinkedList<Node> adjacent;
//
//        public Node(int data) {
//            this.data = data;
//            marked = false;
//            adjacent = new LinkedList<>();
//        }
//    }
//
//    Node[] nodes;
//
//    public Graph(int n) {
//        nodes = new Node[n+1];
//        for (int i = 0; i < n; i++) {
//            nodes[i+1] = new Node(i+1);
//        }
//    }
//
//    public void addEdge(int a, int b) {
//        Node n1 = nodes[a];
//        Node n2 = nodes[b];
//        if (n1.adjacent.contains(n2)) {
//            n1.adjacent.add(n2);
//        }
//        if (n2.adjacent.contains(n1)) {
//            n2.adjacent.add(n1);
//        }
//    }
//
//    public void dfs(int n) {
//        Node root = nodes[n];
//        Stack<Node> stack = new Stack();
//        stack.push(root);
//        root.marked = true;
//        while (!stack.isEmpty()) {
//            Node r = stack.pop();
//            for (Node nod : r.adjacent) {
//                if (!nod.marked) {
//                    nod.marked = true;
//                    stack.push(nod);
//                }
//            }
//            visit(r);
//        }
//    }
//
//    public void bfs(int n) {
//        Node root = nodes[n];
//        Queue<Node> stack = new LinkedList();
//        stack.offer(root);
//        root.marked = true;
//        while (!stack.isEmpty()) {
//            Node r = stack.poll();
//            for (Node nod : r.adjacent) {
//                if (!nod.marked) {
//                    nod.marked = true;
//                    stack.offer(nod);
//                }
//            }visit(r);
//        }
//    }
//
//    public void bfs() {
//        bfs(1);
//    }
//
//    public void dfs() {
//        dfs(1);
//    }
//
//    public void visit(Node n) {
//        System.out.print(n.data + " ");
//    }
//}
//

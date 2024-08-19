package codeTest;

import java.util.*;

public class Solution {
    public int solution(int n, int[][] vertex) {
        // 그래프를 인접 리스트로 표현
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보를 그래프에 추가
        for (int[] edge : vertex) {
            int a = edge[0];
            int b = edge[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        // BFS를 위한 큐 및 거리 배열
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];

        // BFS 초기화
        queue.add(1); // 1번 노드에서 시작
        visited[1] = true;

        // BFS 탐색
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[node] + 1;
                    queue.add(neighbor);
                }
            }
        }

        // 가장 먼 거리 찾기
        int maxDistance = 0;
        for (int dist : distance) {
            if (dist > maxDistance) {
                maxDistance = dist;
            }
        }

        // 가장 먼 거리의 노드 개수 세기
        int count = 0;
        for (int dist : distance) {
            if (dist == maxDistance) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 테스트 데이터 정의
        int n = 6;
        int[][] vertex = {
                {1, 2},
                {1, 3},
                {2, 4},
                {2, 5},
                {3, 6}
        };
        int result = solution.solution(n, vertex);
        System.out.println("The number of nodes farthest from node 1: " + result);
    }
}
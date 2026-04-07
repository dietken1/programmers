package 전력망을둘로나누기_86971;

import java.util.*;

public class Solution_86971 {
  public int solution(int n, int[][] wires) {
    int answer = n;

    // 연결 관계를 정리한 그래프
    List<List<Integer>> graph = new ArrayList<>();
    for (int i=0; i<n; i++) {
      graph.add(new ArrayList<>());
    }

    for(int[] wire : wires) {
      graph.get(wire[0]-1).add(wire[1]);
      graph.get(wire[1]-1).add(wire[0]);
    }

    Queue<Integer> q = new LinkedList<>();

    // bfs
    for(int[] wire : wires) {
      int cnt = 1;
      int[] visited = new int[n];
      int a = wire[0];
      int b = wire[1];
      visited[a-1]++;
      visited[b-1]++;
      q.offer(b);
      while(!q.isEmpty()) {
        int p = q.poll();
        for(int i : graph.get(p-1)) {
          if (visited[i-1] == 0) {
            q.offer(i);
            visited[i-1]++;
            cnt++;
          }
        }
      }
      int diff = Math.abs(n-cnt*2);
      answer = Math.min(diff, answer);
    }

    return answer;
  }
}

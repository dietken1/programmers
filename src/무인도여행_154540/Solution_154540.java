package 무인도여행_154540;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution_154540 {

  public int[] solution(String[] maps) {
    List<Integer> result = new ArrayList<>();
    int[][] visited = new int[maps.length][maps[0].length()];

    for (int i = 0; i < maps.length; i++) {
      for (int j = 0; j < maps[0].length(); j++) {
        if (maps[i].charAt(j) != 'X' && visited[i][j] == 0) {
          visited[i][j] = 1;
          result.add(bfs(maps, visited, i, j));
        }
      }
    }

    if (result.isEmpty()) {
      result.add(-1);
      return result.stream()
          .mapToInt(Integer::intValue)
          .toArray();
    }

    return result.stream()
        .mapToInt(Integer::intValue)
        .sorted()
        .toArray();
  }

  private int bfs(String[] maps, int[][] visited, int x, int y) {
    Deque<int[]> deque = new ArrayDeque<>();
    deque.add(new int[] {x, y});
    int cnt = 0;
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};

    while (!deque.isEmpty()) {
      int[] cur = deque.poll();
      x = cur[0];
      y = cur[1];
      cnt += Integer.parseInt(String.valueOf(maps[x].charAt(y)));

      for (int k = 0; k < 4; k++) {
        int nx = x + dx[k];
        int ny = y + dy[k];
        if (isIsland(maps, nx, ny, visited)) {
          deque.add(new int[] {nx, ny});
          visited[nx][ny] = 1;
        }
      }
    }

    return cnt;
  }

  private boolean isIsland(String[] maps, int nx, int ny, int[][] visited) {
    return nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length()
        && maps[nx].charAt(ny) != 'X' && visited[nx][ny] == 0;
  }
}
package 하노이의탑_12946;

import java.util.*;

public class Solution_12946 {
  public int[][] solution(int n) {
    List<int[]> list = new ArrayList<>();
    hanoi(n, 1, 2, 3, list);
    int[][] answer = list.toArray(new int[list.size()][]);
    return answer;
  }

  private void hanoi(int n, int start, int via, int dest, List<int[]> list) {
    if (n==0) {
      return;
    }

    // 마지막 원판을 제외한 원판을 경유탑에 쌓음
    hanoi(n-1, start, dest, via, list);

    // 마지막 원판 1개를 도착탑에 쌓음
    list.add(new int[]{start,dest});

    // 경유탑에 쌓인 원판을 도착탑에 쌓음
    hanoi(n-1, via, start, dest, list);
  }
}

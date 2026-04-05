package 선인장숨기기_468379;

import java.util.*;

class Solution {
  public int[] solution(int m, int n, int h, int w, int[][] drops) {
    int[] answer = new int[2];
    int[][] arr = new int[m][n];
    for (int p=0; p < m; p++) {
      Arrays.fill(arr[p], m*n);
    }

    // 먼저 비가 오는 구역을 rainArr에 채워넣는다
    for (int k=0; k < drops.length; k++) {
      arr[drops[k][0]][drops[k][1]] = k;
    }

    // 안전한 영역 찾기
    int maxInWorld = 0;
    for (int i=0; i<=m-h; i++) {
      for (int j=0; j<=n-w; j++) {
        int minInLand = m*n;
        for (int a=0; a<h; a++) {
          for (int b=0; b<w; b++) {
            if (arr[i+a][j+b] < minInLand) {
              minInLand = arr[i+a][j+b];
            }
          }
        }
        if (minInLand == m*n) {
          answer[0] = i;
          answer[1] = j;
          return answer;
        }
        if (minInLand > maxInWorld) {
          maxInWorld = minInLand;
          answer[0] = i;
          answer[1] = j;
        }
        System.out.println(minInLand + " " + i + " " + j);
      }
    }
    return answer;
  }
}

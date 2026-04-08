package 합승택시요금_72431;

public class Solution_72431 {
  final static int inf = 100000*200+1;
  public int solution(int n, int s, int a, int b, int[][] fares) {
    int answer = inf;
    int[][] distance = new int[n][n];
    for (int i=0; i<n; i++) {
      for (int j=0; j<n; j++) {
        distance[i][j] = (i==j) ? 0 : inf;
      }
    }

    for (int[] arr : fares) {
      distance[arr[0]-1][arr[1]-1]=arr[2];
      distance[arr[1]-1][arr[0]-1]=arr[2];
    }

    for (int target=0; target<n; target++) {
      int[] visited = new int[n];
      visited[target] = 1;

      for (int i=0; i<n; i++) {
        int minIndex = -1;
        int minVal = inf;

        for (int j=0; j<n; j++) {
          if (visited[j] != 1 && distance[target][j] != inf) {
            if (distance[target][j] < minVal) {
              minVal = distance[target][j];
              minIndex = j;
            }
          }
        }
        if (minIndex == -1) {
          break;
        }

        visited[minIndex] = 1;
        dijkstra(target, minIndex, distance);
      }
    }

    for(int i=0; i<n; i++) {
      answer = Math.min(answer, distance[s-1][i] + distance[i][a-1] + distance[i][b-1]);
    }

    return answer;
  }

  private void dijkstra(int st, int dst, int[][] distance) {
    for (int i=0; i<distance[0].length; i++) {
      if(distance[dst][i]!=inf || i!=st || i!=dst) {
        int dist = Math.min(distance[st][i], distance[st][dst]+distance[dst][i]);
        distance[st][i] = dist;
      }
    }
  }
}

package 단속카메라_42884;

import java.util.*;

public class Solution_42884 {
  public int solution(int[][] routes) {
    int answer = 1;
    Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));

    int currentIndex=0;
    for (int i=1; i<routes.length; i++) {
      if(routes[i][0] > routes[currentIndex][1]) {
        answer++;
        currentIndex=i;
      }
    }
    return answer;
  }
}

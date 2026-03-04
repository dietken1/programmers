package 혼자놀기의달인_131130;

import java.util.*;
import java.util.stream.Collectors;

class Problem_131130 {
  public int solution(int[] cards) {
      ArrayList<Integer> results = new ArrayList<>();
      for (int i = 1; i <= cards.length; i++) {
        results.add(sol(cards, i));
      }
      List<Integer> topTwo = results.stream()
          .sorted(Comparator.reverseOrder())
          .limit(2)
          .collect(Collectors.toList());

      int result = topTwo.get(0) * topTwo.get(1);
      return result;
    }

    public int sol(int[] cards, int start) {
      int cnt = 0;

      while (true) {
        int temp = cards[start-1];
        if (cards[start-1] != 0) {
          cnt += 1;
          cards[start-1] = 0;
          start = temp;
          continue;
        }
        break;
      }
      return cnt;
    }
  }
}
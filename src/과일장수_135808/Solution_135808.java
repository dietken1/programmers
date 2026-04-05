package 과일장수_135808;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_135808 {
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

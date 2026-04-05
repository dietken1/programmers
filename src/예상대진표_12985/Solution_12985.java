package 예상대진표_12985;

public class Solution_12985 {
  public int solution(int n, int a, int b)
  {
    int answer = 0;

    while (a != b) {
      a = (int) Math.round(a/2.0);
      b = (int) Math.round(b/2.0);
      answer += 1;
    }

    return answer;
  }
}

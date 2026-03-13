package 숫자짝꿍_131128;

public class Problem_131128 {
  public String solution(String X, String Y) {
    StringBuilder sb = new StringBuilder();

    for (int i = 9; i >= 0; i--) {
      int a = countingCharInString(X, Integer.toString(i).charAt(0));
      int b = countingCharInString(Y, Integer.toString(i).charAt(0));
      int cnt = Math.min(a, b);

      sb.append(Integer.toString(i).repeat(cnt));
    }

    if (sb.length() == 0) {
      return "-1";
    } else if (sb.charAt(0) == '0') {
      return "0";
    }

    return sb.toString();
  }

  public int countingCharInString(String s, char c) {
    int cnt = 0;
    for (char i : s.toCharArray()) {
      if (i == c) {
        cnt += 1;
      }
    }
    return cnt;
  }
}

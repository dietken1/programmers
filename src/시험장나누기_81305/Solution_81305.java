package 시험장나누기_81305;

public class Solution_81305 {
  public int solution(int k, int[] num, int[][] links) {
    int n = num.length; // 노드의 개수

    // 루트 찾기
    boolean[] hasParent = new boolean[n];
    for (int[] link : links) {
      if (link[0] != -1) {hasParent[link[0]] = true;}
      if (link[1] != -1) {hasParent[link[1]] = true;}
    }
    int root = 0;
    for (int i = 0; i < n; i++) {
      if (!hasParent[i]) {
        root = i;
        break;
      }
    }

    // 이분 탐색을 위한 최대 최소 설정
    int minVal = 0;
    int maxVal = 0;
    for(int i = 0; i < n; i++) {
      maxVal += num[i];
      minVal = Math.max(minVal, num[i]);
    }

    int low = minVal;
    int high = maxVal;
    int answer = maxVal;

    // 이분 탐색
    while(low <= high) {
      int mid = (low + high) / 2;
      if (sol(root, mid, num, links) <= k) {
        answer = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return answer;
  }

  private int sol(int root, int maxVal, int[] num, int[][] links) {
    return dfs(root, maxVal, new int[]{0, 1}, num, links)[1];
  }

  private int[] dfs(int parent, int maxVal, int[] arr, int[] num, int[][] links) {
    int leftSum = 0;
    int rightSum = 0;

    // 왼쪽 자식 처리
    if (links[parent][0] != -1) {
      leftSum = dfs(links[parent][0], maxVal, arr, num, links)[0];
    }
    // 오른쪽 자식 처리
    if (links[parent][1] != -1) {
      rightSum = dfs(links[parent][1], maxVal, arr, num, links)[0];
    }

    // 1. 양쪽 자식 모두 포함 가능
    if (num[parent] + leftSum + rightSum <= maxVal) {
      arr[0] = num[parent] + leftSum + rightSum;
    }
    // 2. 한쪽 자식만 포함 가능
    else if (num[parent] + Math.min(leftSum, rightSum) <= maxVal) {
      arr[1]++; // 큰 쪽 하나를 자름 (그룹 추가)
      arr[0] = num[parent] + Math.min(leftSum, rightSum);
    }
    // 3. 둘 다 포함 불가능
    else {
      arr[1] += 2;
      arr[0] = num[parent];
    }

    return new int[]{arr[0], arr[1]};
  }
}

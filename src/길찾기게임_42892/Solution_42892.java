package 길찾기게임_42892;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node {
  int id, x, y;
  Node left, right;

  public Node(int id, int x, int y) {
    this.id = id;
    this.x = x;
    this.y = y;
  }
}

public class Solution_42892 {
  public int[][] solution(int[][] nodeinfo) {
    int len = nodeinfo.length;
    Node[] nodes = new Node[len];

    // 1. 노드 생성
    for(int i = 0; i < len; i++) {
      nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
    }

    // 2. y축 내림차순 + x축 오름차순 정렬
    Arrays.sort(nodes, (n1, n2) -> {
      if (n1.y == n2.y) return n1.x - n2.x;
      return n2.y - n1.y;
    });

    // 3. 트리 구성
    Node root = nodes[0];
    for(int i = 1; i < len; i++) {
      insertNode(root, nodes[i]);
    }

    List<Integer> pre = new ArrayList<>();
    List<Integer> post = new ArrayList<>();

    preOrder(root, pre);
    postOrder(root, post);

    int[][] answer = new int[2][len];
    for(int i = 0; i < len; i++) {
      answer[0][i] = pre.get(i);
      answer[1][i] = post.get(i);
    }

    return answer;
  }

  private void insertNode(Node parent, Node child) {
    if (child.x < parent.x) {
      if (parent.left == null) parent.left = child;
      else insertNode(parent.left, child);
    } else {
      if (parent.right == null) parent.right = child;
      else insertNode(parent.right, child);
    }
  }

  private void preOrder(Node node, List<Integer> list) {
    if (node == null) return;
    list.add(node.id);
    preOrder(node.left, list);
    preOrder(node.right, list);
  }

  private void postOrder(Node node, List<Integer> list) {
    if (node == null) return;
    postOrder(node.left, list);
    postOrder(node.right, list);
    list.add(node.id);
  }
}

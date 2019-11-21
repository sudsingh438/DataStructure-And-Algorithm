import java.util.ArrayList;
import java.util.List;

public class CriticalNode {

  public static void main(String[] args) {
    CriticalNode solution = new CriticalNode();
    //solution.criticalConnections()
  }

  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    int[] nodes = new int[n];
    for (List<Integer> node: connections) {
      for (int nodeVal : node) {
        nodes[nodeVal] = nodes[nodeVal] + 1;
      }
    }

    int index=0;
    List<List<Integer>> connectionsRsp = new ArrayList<List<Integer>>();
    for (int nodeConn : nodes) {
      if (nodeConn == 1) {
        for (List<Integer> node: connections) {
          for (int nodeVal : node) {
            if (nodeVal == index) {
              connectionsRsp.add(node);
            }
          }
        }
      }
      index++;
    }

    return connectionsRsp;
  }
}

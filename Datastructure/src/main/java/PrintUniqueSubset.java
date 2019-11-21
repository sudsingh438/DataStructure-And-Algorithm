import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PrintUniqueSubset {


  public static void main(String[] args) {
    int input[] = {1,2,3};
    PrintUniqueSubset solution = new PrintUniqueSubset();
    System.out.print(solution.subsets(input));
  }

    private Set<List<Integer>> resultSet =  new HashSet<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
      printSubSets(nums, 0, nums.length, new ArrayList<Integer>());
      return new ArrayList<>(resultSet);
    }

    public void  printSubSets(int[] nums, int startIndex, int endIndex, List<Integer> inputList) {
      if (startIndex == endIndex) {
        resultSet.add(inputList);
        return;
      }
      List<Integer> itemList1 = new ArrayList<>(inputList);
      List<Integer> itemList2 = new ArrayList<>(inputList);
      printSubSets(nums, startIndex+1, endIndex, itemList1);
      itemList2.add(nums[startIndex]);
      printSubSets(nums, startIndex+1, endIndex, itemList2);
    }
}

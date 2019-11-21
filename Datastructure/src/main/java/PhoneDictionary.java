

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class PhoneDictionary {
  public static void main(String[] args) {

  }

  ArrayList<String> customSort(ArrayList<String> inputList) {
    ArrayList<String> result = new ArrayList<String>();

    TreeMap<Integer, List<String>> treeMap = new TreeMap<Integer, List<String>>();

    for (String input: inputList) {
      int order = this.uniqueCharacters(input);
      List<String> temp = treeMap.get(order);
      if (temp == null) {
        temp = new ArrayList<String>();
      }
      temp.add(input);
      treeMap.put(order, temp);
    }
//
//    for (Map.Entry entry : treeMap.entrySet()) {
//      if (entry.getValue() != null) {
//        List<String> val = (List<String>) entry.getValue() ;
//        val.size()
//        for (String input: entry.getValue()) {
//
//        }
//      }
//    }

    return result;
  }

  public static int uniqueCharacters(String test){
    HashSet<Character> set = new HashSet<>();
      String temp = "";
      for (int i = 0; i < test.length(); i++){
        set.add(test.charAt(i));
      }
      return set.size();
  }
}

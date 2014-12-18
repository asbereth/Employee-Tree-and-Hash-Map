import java.util.*;

import MyClasses.*;

public class testEmployeeTree {
  static public void main (String[] arguments) throws Exception{
    String[] test;
    EmployeeHashMap employeeMapping = new EmployeeHashMap();
    
    EmployeeTree tree = new EmployeeTree();
    
    try {
      test = IOStuff.convertLineByLine("data.txt");
    } catch (Exception exception) {
      throw new Exception ("don't troll");
    }
    
    for (int k = 0; k < test.length; ++k) {
      employeeMapping.put(
    	test[k].replaceAll(" ","").split(",")[0], 
    	test[k].replaceAll(" ","").split(",")[1]);
    }
    
    tree.buildTree(employeeMapping);
    tree.printTree();
    
  }
}

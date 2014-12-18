import java.util.*;

import MyClasses.*;

public class testEmployeeHashMap {
  
  static public void main(String[] arguments) {
    String test[], CEO = new String();
    
    EmployeeHashMap employeeMapping = 
      new EmployeeHashMap();
    
    try {
      test = IOStuff.convertLineByLine("data.txt");
    }
    catch (Exception exception) {
      throw new Error("some issue with the file");
    }
    
    HashMap<String, ArrayList<String>> employeeTree = 
      new HashMap<String, ArrayList<String>>();
    
    
    for (int k = 0; k < test.length; ++k) {      
      employeeMapping.put(
    	test[k].replaceAll(" ","").split(",")[0], 
    	test[k].replaceAll(" ","").split(",")[1]);
    }
    
    if (!employeeMapping.containsValue("-") ) {
      throw new Error("you must have a CEO");
    } else {
      for (String check : employeeMapping.keySet() ) {
	if (employeeMapping.get(check).equals("-")) {
	  CEO = check;
	  break;
	}
      }
    }
    
    
    for (String key : employeeMapping.keySet() ) {
      if (!employeeTree.containsKey(employeeMapping.get(key) ) && 
    	  !employeeMapping.get(key).equals("-") ) {
    	employeeTree.put(employeeMapping.get(key), 
    			 employeeMapping.computeSubordinates( 
    			   employeeMapping.get(key)));
      }
      
    }
    
    IOStuff.printTree(employeeTree);
    // System.out.println(employeeTree);
    
  }
}


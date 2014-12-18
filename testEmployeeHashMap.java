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
    
    employeeMapping.printParent(CEO);
    
  }
}


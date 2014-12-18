import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Exception;

import java.util.*;

import MyClasses.*;

class IOStuff {
  static public String[] convertLineByLine (String filename) throws Exception{
    File file = new File(filename);
    FileReader fileReader = new FileReader(file);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    StringBuffer stringBuffer = new StringBuffer();
    String line;
    
    while ((line = bufferedReader.readLine()) != null) {
      stringBuffer.append(line);
      stringBuffer.append("\n");
    }
    
    fileReader.close();
    
    String lines[] = 
      stringBuffer.toString().split(System.getProperty("line.separator"));
    return lines;
  }
  
  static public void printTree(HashMap<String, String[]> tree) {
    for (String employee : tree.keySet() ) {
      System.out.println(employee + ": " +  Arrays.toString(tree.get(employee) ) ) ;
    }
    
  }
}

public class testTree {
  
  static public void main(String[] arguments) {
    String test[], CEO = new String();
    
    EmployeeHashMap employeeMapping = 
      new EmployeeHashMap();
    
    try {
      test = IOStuff.convertLineByLine("data.txt");
    }
    catch (Exception exception) {
      throw new Error("don't troll");
    }
    
    HashMap<String, String[]> employeeTree = 
      new HashMap<String, String[]>();
    
    
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
			 employeeMapping.computeSubordinates( employeeMapping.get(key)));
      }
      
    }
    
    IOStuff.printTree(employeeTree);
    // System.out.println(employeeTree);
    
  }
}


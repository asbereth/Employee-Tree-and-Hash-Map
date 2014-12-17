import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Exception;

import java.util.*;

public class testTree {
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
  
  static public void main(String[] arguments) {
    String test[];
    
    HashMap<String, String> employeeMapping = new HashMap<String, String>();
    
    try {
      test = convertLineByLine("data.txt");
    }
    catch (Exception exception) {
      throw new Error("don't troll");
    }
    
    // current = test[0].replaceAll(" ","").split(",");
    
    for (int k = 0; k < test.length; ++k) {
      
      // check if the data contains an employee who reports to two managers
      if(employeeMapping.containsKey(test[k].replaceAll(" ","").split(",")[0])) {
	throw new Error("not valid, an employee can't have two managers");
      }
      
      if(employeeMapping.containsKey(test[k].replaceAll(" ","").split(",")[1])) {
	if (employeeMapping.get(test[k].replaceAll(" ","").split(",")[1]).equals(
	    test[k].replaceAll(" ","").split(",")[0]  ) ) {
	  throw new Error("not valid, tree can't have cycles. ");
	} 
      }

      
      employeeMapping.put(
	test[k].replaceAll(" ","").split(",")[0], 
	test[k].replaceAll(" ","").split(",")[1]);
    }
    
    System.out.println(employeeMapping);
  }
}


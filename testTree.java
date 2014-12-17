import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Exception;

import java.util.*;

class EmployeeHashMap<K, V> extends HashMap<K,V> {
  
  @Override public V put (K key, V value) {
    if (containsKey(key)) {
      throw new Error("not valid, an employee can't have two managers");
    }
    
    if (containsKey(value) ) {
      if (get(value).equals(key)) {
	throw new Error("not valid, a tree can't have cycles");
      }
    }
    
    return super.put(key, value);
  }
}

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
    
    EmployeeHashMap<String, String> employeeMapping = 
      new EmployeeHashMap<String, String>();
    
    try {
      test = convertLineByLine("data.txt");
    }
    catch (Exception exception) {
      throw new Error("don't troll");
    }
    
    for (int k = 0; k < test.length; ++k) {      
      employeeMapping.put(
    	test[k].replaceAll(" ","").split(",")[0], 
    	test[k].replaceAll(" ","").split(",")[1]);
    }
    
    System.out.println(employeeMapping);
  }
}


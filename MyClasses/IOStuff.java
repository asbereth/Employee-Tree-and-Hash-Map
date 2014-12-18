package MyClasses;

import java.util.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Exception;



public class IOStuff {
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
      System.out.println(employee + ": " +  
	Arrays.toString(tree.get(employee) ));
    }
    
  }
}

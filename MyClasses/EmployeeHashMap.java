package MyClasses;

import java.util.*;

public class EmployeeHashMap extends HashMap<String, String> {
  
  @Override public String put (String key, String value) {
    if (containsKey(key)) {
      throw new Error("not valid, an employee can't have two managers");
    }
    
    if (containsKey(value) ) {
      if (get(value).equals(key)) {
	throw new Error("not valid, a tree can't have cycles");
      }
    }
    
    if (value.equals("-") && containsValue("-") ) {
      throw new Error("Can't only have one CEO");
    }
    
    return super.put(key, value);
  }
  
  public String[] computeSubordinates (String employeeName) {
    ArrayList<String> listOfSubordinates = new ArrayList<String>();
    
    if (this.containsKey(employeeName) && 
	!this.containsValue(employeeName)) {
      System.out.println(employeeName + " does not have subordinates");
      return null;
    }
    
    if (!this.containsKey(employeeName)) {
      System.out.println(employeeName + " doesn't exist");
      return null;
    }
    
    for (String key : this.keySet()) {
      if (this.get(key).equals(employeeName)) {
	listOfSubordinates.add( key );
      }
    }
    
    String[] finalArray = new String[listOfSubordinates.size()];
    
    return listOfSubordinates.toArray(finalArray);
  }
  
}


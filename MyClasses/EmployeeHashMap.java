package MyClasses;

import java.util.*;

public class EmployeeHashMap extends HashMap<String, String> {
  
  @Override public String put (String key, String value) {
    if (containsKey(key)) {
      if (!get(key).equals(value)) {
	throw new Error("not valid, an employee can't have two managers");
      }
    }
    
    if (containsKey(value) ) {
      if (get(value).equals(key)) {
	throw new Error("not valid, a tree can't have cycles");
      }
    }
    
    if (value.equals("-") && containsValue("-") ) {
      throw new Error("can only have one CEO");
    }
    
    return super.put(key, value);
  }
  
  public ArrayList<String> computeSubordinates (String employeeName) {
    ArrayList<String> listOfSubordinates = new ArrayList<String>();
    
    for (String key : this.keySet()) {
      if (this.get(key).equals(employeeName)) {
	listOfSubordinates.add( key );
      }
    }
    
    return listOfSubordinates;
  }
  
}


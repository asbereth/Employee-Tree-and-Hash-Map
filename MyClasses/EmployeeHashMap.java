// This class is designed to read in the parsed information from the 
// text file. EmployeeHashMap is basically a HashMap where both the 
// key and value are of String type. The method put() has been 
// overriden to ensure that each key is unique (since a key represents 
// an employee, and an employee cannot have more than one superiors, 
// and also to ensure that there are no cycles in the data, since the 
// data will later on be converted onto a tree structure. 

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
  
  public String getCEO() {
    String CEO = new String();
    if (!this.containsValue("-") ) {
      throw new Error("you must have a CEO");
    } else {
      for (String check : this.keySet() ) {
	if (this.get(check).equals("-")) {
	  CEO = check;
	  break;
	}
      }
    }
    return CEO;
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

  public void printTree() {
    printParent(getCEO());
  }
  
  private void printParent(String parentName) {
    if (!computeSubordinates(parentName).isEmpty()) {
      System.out.println(parentName + ": " + computeSubordinates(parentName) );
      printChildren(parentName);
    }
  }
  
  private void printChildren(String parentName) {
    for (String child: computeSubordinates(parentName)) {
      printParent(child);
    } 
  }
  
}


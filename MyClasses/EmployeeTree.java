package MyClasses;

import java.util.*;

public class EmployeeTree {
  
  // EmployeeHashMap employeeMapping = new EmployeeHashMap();
  
  String employeeName;
  ArrayList<EmployeeTree> children = new ArrayList<EmployeeTree>();
  
  
  // constructor
  // public EmployeeTree (String name) {
  //   this.employeeName = name;
  //   this.children = new ArrayList<EmployeeTree>();
  // }
  
  public String getEmployeeName() {
    return employeeName;
  }
  
  public ArrayList<EmployeeTree> getChildren() {
    return children;
  }
  
  public String toString() {
    return getEmployeeName();
  }
  
  private String getCEO(EmployeeHashMap employeeMapping) {
    String CEO = new String();
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
    return CEO;
  }
  
  public void buildTree(EmployeeHashMap employeeMapping) {
    this.insertNode(employeeMapping,
      getCEO(employeeMapping));
  }
  
  // insertNode() and insertChildren() are mutually recursive
  private void insertNode(EmployeeHashMap employeeMapping, 
    String name) {
    this.employeeName = name;
    insertChildren(employeeMapping, name);
  }
  
  private void insertChildren (EmployeeHashMap employeeMapping, 
    String name) {
    int counter = 0;
    ArrayList<String> nameChildren = new ArrayList<String>();
    nameChildren = findChildren(employeeMapping, name);
    
    for (String child: nameChildren) {
      this.children.add(new EmployeeTree());
      this.children.get(counter).insertNode(employeeMapping, child);
      counter++;
    }
  }
  
  public ArrayList<String> findChildren(EmployeeHashMap employeeMapping, 
    String parentName) {
    ArrayList<String> listOfChildren = new ArrayList<String>();
    
    for (String key: employeeMapping.keySet()) {
      if(employeeMapping.get(key).equals(parentName)) {
	listOfChildren.add(key);
      }
    }
    return listOfChildren;
  }
  
  
  public void printTree() {
    if (!children.isEmpty()) {
      System.out.println(this.employeeName + ": " + this.children);
      printChildren();
    }
  }
  
  private void printChildren() {
    for (EmployeeTree child: this.children)
      child.printTree();
  }
  
}

// This class is designed to hold a managerial hierarchy within a 
// tree structure. A node consists of an employee name, and the 
// list of the names of that employee's subordinates. 

package MyClasses;
import java.util.*;

public class EmployeeTree {
  
  String employeeName;
  ArrayList<EmployeeTree> children = new ArrayList<EmployeeTree>();
  
  public String getEmployeeName() {
    return employeeName;
  }
  
  public void setEmployeeName(String name) {
    this.employeeName = name;
  }
  
  public ArrayList<EmployeeTree> getChildren() {
    return children;
  }
  
  public String toString() {
    return getEmployeeName();
  }
  
  private String getCEO(EmployeeHashMap employeeMapping) {
    return employeeMapping.getCEO();
  }
  
  public void buildTree(EmployeeHashMap employeeMapping) {
    this.insertNode(employeeMapping,
      getCEO(employeeMapping));
  }
  
  // insertNode() and insertChildren() are mutually recursive
  private void insertNode(EmployeeHashMap employeeMapping, 
    String name) {
    this.setEmployeeName(name);
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
    return employeeMapping.computeSubordinates(parentName);
  }
  
  // printTree() and printChildren() are defined to be mutually 
  // recursive, traversing a depth-first tree algorithm
  public void printTree() {
    if (!children.isEmpty()) {
      System.out.println(this.getEmployeeName() + ": " + 
	this.getChildren());
      printChildren();
    }
  }
  
  private void printChildren() {
    for (EmployeeTree child: this.getChildren())
      child.printTree();
  }
  
}

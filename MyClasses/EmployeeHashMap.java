package MyClasses;

import java.util.*;

public class EmployeeHashMap<K, V> extends HashMap<K,V> {
  
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


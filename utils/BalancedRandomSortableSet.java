package pacman.utils;


import java.util.Set;

public interface BalancedRandomSortableSet extends Set {
  
  // Based on "reSort" method
  public BalancedRandomSortable top(); // All the "top" methods will return item randomly but based on the weight at the same time
  public BalancedRandomSortable[] top(int topNum); // The returned items should be different
  
  public void reSort(); // Will be invoked before any "top" method. It will sort the items randomly but based on their weight at the same time
  
  public Set getFullSet();
}

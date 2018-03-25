package pacman;

import java.util.*;

import pacman.utils.*;

public class TacticSet implements TacticSetInterface {
  private Set<TacticInterface> tactics;

  public TacticSet(int tacticNum) {
    // Up, Down, Left, Right, Stay, Dig, Float
    tactics = new LinkedHashSet<TacticInterface>(tacticNum);
  }

  public static void main(String[] args) {
    TacticSet tacticSet = new TacticSet(7);
  }

  public BalancedRandomSortable top() {
    this.reSort();
    Iterator iter = tactics.iterator();
    BalancedRandomSortable top = (BalancedRandomSortable)iter.next();
    return top;
  }

  public BalancedRandomSortable[] top(int topNum) {
    this.reSort();
    if (tactics.size() < topNum) {
      return (BalancedRandomSortable[])this.toArray();
    }
    BalancedRandomSortable[] result = new BalancedRandomSortable[topNum];
    Iterator iter = tactics.iterator();
    for (int i = 0; i < topNum; i++) {
      result[i] = (BalancedRandomSortable)iter.next();
    }

    return result;
  }

  // This will sort the tactics Set
  public void reSort() {
    LinkedList<TacticInterface> tacticList = new LinkedList<TacticInterface>(tactics);
    tacticList.sort(new Comparator<TacticInterface>() {
      @Override
      public int compare(TacticInterface t1, TacticInterface t2) {
        int result = (int)(t1.getWeight() - t2.getWeight());
        if (result == 0) return result;
        return (result > 0) ? 1 : -1;
      }
    });
    LinkedList<TacticInterface> expandedTactics = new LinkedList<TacticInterface>();
    // TODO
  }

  public int size() {
    return tactics.size();
  }

  public boolean isEmpty() {
    return tactics.isEmpty();
  }

  public boolean contains(Object o) {
    boolean result = false;
    if (o instanceof TacticInterface) {
      result = tactics.contains(o);
      return result;
    }
    return false;
  }

  public Iterator iterator() {
    return tactics.iterator();
  }

  public Object[] toArray() {
    return tactics.toArray();
  }

  public Object[] toArray(Object[] a) {
    return tactics.toArray(a);
  }

  public boolean add(Object e) {
    boolean result = false;
    if (e instanceof TacticInterface) {
      result = tactics.add((TacticInterface)e);
      return result;
    }
    return false;
  }

  public boolean remove(Object o) {
    boolean result = false;
    if (o instanceof TacticInterface) {
      result = tactics.remove(o);
      return result;
    }
    return false;
  }

  public boolean containsAll(Collection c) {
    boolean result = false;
    if (c instanceof TacticSetInterface) {
      result = tactics.containsAll(c);
      return result;
    }
    return false;
  }

  public boolean addAll(Collection c) {
    boolean result = false;
    if (c instanceof TacticSetInterface) {
      TacticSetInterface c1 = (TacticSetInterface)c;
      result = tactics.addAll(c1.getFullSet());
      return result;
    }
    return false;
  }

  public boolean retainAll(Collection c) {
    boolean result = false;
    if (c instanceof TacticSetInterface) {
      TacticSetInterface c1 = (TacticSetInterface)c;
      result = tactics.retainAll(c1.getFullSet());
      return result;
    }
    return false;
  }

  public boolean removeAll(Collection c) {
    boolean result = false;
    if (c instanceof TacticSetInterface) {
      TacticSetInterface c1 = (TacticSetInterface)c;
      result = tactics.removeAll(c1.getFullSet());
      return result;
    }
    return false;
  }

  public void clear() {
    tactics.clear();
  }

  public Set getFullSet() {
    return tactics;
  }

  @Override
  public boolean equals(Object o) {
    boolean result = false;
    if (o instanceof TacticSetInterface) {
      result = tactics.equals(((TacticSetInterface)o).getTactics());
      return result;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return tactics.hashCode();
  }

  @Override
  public Set getTactics() {
    return getFullSet();
  }
}

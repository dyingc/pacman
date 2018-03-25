package pacman.utils;


public interface TacticInterface extends BalancedRandomSortable {
  public String getTacticName();
  public void action(EntityInterface entity);
}
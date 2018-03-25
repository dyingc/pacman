package pacman;

import pacman.utils.EntityInterface;
import pacman.utils.TacticInterface;

public abstract class Tactic implements TacticInterface {
  private float weight = 0;

  public abstract String getTacticName();
  
  public abstract void action(EntityInterface entity);

  public void setWeight(float weight) {
    this.weight = weight;
  }

  public float getWeight() {
    return weight;
  }
}

package pacman.utils;

public interface SolutionInterface {
  public PuzzleInterface getPuzzle();
  public TacticInterface getTactic();
  public void setTactic(TacticInterface tactic);
}
